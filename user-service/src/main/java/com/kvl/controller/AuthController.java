package com.kvl.controller;


import com.kvl.payload.dto.LoginDTO;
import com.kvl.payload.dto.SignupDTO;
import com.kvl.payload.response.AuthResponse;
import com.kvl.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private  final AuthService authService;


    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(
            @RequestBody SignupDTO req
            ) throws Exception {
        AuthResponse response = authService.signup(req);
        return  ResponseEntity.ok(response);

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginDTO req
            ) throws Exception {
        AuthResponse response = authService.login(req.getEmail(),req.getPassword());
        return  ResponseEntity.ok(response);
    }

    @GetMapping("/access-token/refresh-token/{refreshToken}")
    public ResponseEntity<AuthResponse> getAccessToken(
            @PathVariable String refreshToken
    ) throws Exception {
        AuthResponse response = authService.getAcessTokenFromRefreshToken(refreshToken);
        return  ResponseEntity.ok(response);

    }
}
