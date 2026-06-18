package com.kvl.service;


import com.kvl.payload.dto.SignupDTO;
import com.kvl.payload.response.AuthResponse;

public interface AuthService {

    AuthResponse login(String username, String password);
    AuthResponse signup(SignupDTO req);
    AuthResponse getAcessTokenFromRefreshToken(String refreshToken);



}
