package com.kvl.service;


import com.kvl.payload.dto.SignupDTO;
import com.kvl.payload.response.AuthResponse;

public interface AuthService {

    AuthResponse login(String username, String password) throws Exception;
    AuthResponse signup(SignupDTO req) throws Exception;
    AuthResponse getAcessTokenFromRefreshToken(String refreshToken) throws Exception;



}
