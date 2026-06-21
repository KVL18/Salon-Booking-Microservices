package com.kvl.service;

import com.kvl.exception.UserException;
import com.kvl.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(Long id) throws UserException;

    List<User> getAllUsers();
    void deleteUser(Long id) throws UserException;

    User updateUser(Long id, User user) throws UserException;
    User getUserFromJwt(String jwt) throws Exception;
}
