package com.kvl.service.impl;

import com.kvl.exception.UserException;
import com.kvl.model.User;
import com.kvl.payload.dto.KeycloakUserDTO;
import com.kvl.repository.UserRepository;
import com.kvl.service.KeycloakService;
import com.kvl.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service; 

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final KeycloakService keycloakService;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserException {
        Optional<User> otp = userRepository.findById(id);
        if(otp.isPresent()){
            return otp.get();
        }
        throw new UserException("USER NOT FOUND");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) throws UserException {
        Optional<User> otp = userRepository.findById(id);
        if(otp.isEmpty()){
            throw new UserException("user not found");
        }
        userRepository.deleteById(otp.get().getId());

    }

    @Override
    public User updateUser(Long id, User user) throws UserException {
        Optional<User> otp = userRepository.findById(id);
        if(otp.isEmpty()){
            throw new UserException("user not found");
        }
        User existingUser = otp.get();
        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        existingUser.setUserName(user.getUserName());

        return userRepository.save(existingUser);
    }

    @Override
    public User getUserFromJwt(String jwt) throws Exception {
       KeycloakUserDTO keycloakUserDTO=  keycloakService.fetchUserProfileByJwt(jwt);
        User user = userRepository.findByEmail(keycloakUserDTO.getEmail());
        return user;
    }
}
