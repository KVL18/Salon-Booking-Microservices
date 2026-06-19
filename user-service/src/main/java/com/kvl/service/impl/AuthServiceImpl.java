package com.kvl.service.impl;

import com.kvl.model.User;
import com.kvl.payload.dto.SignupDTO;
import com.kvl.payload.response.AuthResponse;
import com.kvl.payload.response.TokenResponse;
import com.kvl.repository.UserRepository;
import com.kvl.service.AuthService;
import com.kvl.service.KeycloakService;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private  final UserRepository userRepository;
    private final KeycloakService keycloakService;

    @Override
    public AuthResponse login(String username, String password) throws Exception {

        TokenResponse tokenResponse = keycloakService.getAdminAccessToken(
                username,
                password,
                "password",null
        );
        AuthResponse authResponse= new AuthResponse();
        authResponse.setRefresh_token(tokenResponse.getRefreshToken());
        authResponse.setJwt(tokenResponse.getAccessToken());

        authResponse.setMessage("Login successfully");

        return  authResponse;
    }

    @Override
    public AuthResponse signup(SignupDTO req) throws Exception {
        keycloakService.createUser(req);
        User user = new User();
        user.setUserName(req.getUsername());
        user.setPassword(req.getPassword());
        user.setEmail(req.getEmail());
        user.setRole(req.getRole());
        user.setFullName(req.getFullName());
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);
        TokenResponse tokenResponse = keycloakService.getAdminAccessToken(
                req.getUsername(),
                req.getPassword(),
                "password",null
        );
        AuthResponse authResponse= new AuthResponse();
        authResponse.setRefresh_token(tokenResponse.getRefreshToken());
        authResponse.setJwt(tokenResponse.getAccessToken());
        authResponse.setRole(user.getRole());
        authResponse.setMessage("Registered successfully");

        return  authResponse;
    }

    @Override
    public AuthResponse getAcessTokenFromRefreshToken(String refreshToken) throws Exception {
        TokenResponse tokenResponse = keycloakService.getAdminAccessToken(
               null,null,
                "refresh_token",refreshToken
        );
        AuthResponse authResponse= new AuthResponse();
        authResponse.setRefresh_token(tokenResponse.getRefreshToken());
        authResponse.setJwt(tokenResponse.getAccessToken());

        authResponse.setMessage("Access token received");

        return  authResponse;
    }
}
