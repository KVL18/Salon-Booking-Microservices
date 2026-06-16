package com.kvl.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class KeycloakService {

    private static final String KEYCLOAK_BASE_URL = "http://localhost:8080";
    private static final String KEYCLOAK_ADMIN_API = KEYCLOAK_BASE_URL +"/admin/realms/master/users";

    private static  final  String TOKEN_URL = KEYCLOAK_BASE_URL+ "/realms/master/protocol/openid-connect/token";

    private static final String CLIENT_ID = "salon-booking-client";
    private static final String CLIENT_SECRET = "9lf7EaeCZcEJ92n2gphHUCtCKv4pbK0C";
    private static  final String GRANT_TYPE = "password";
    private static  final  String scope = "openid profile email";

    private static final String username ="kvl";
    private  static final String password = "admin";
    private static  final String getClientId = "3bbb89c2-9c72-4bc4-93d7-869a392b4356";


    private final RestTemplate restTemplate;

    public void createUser(SignupDTO signupDTO) throws Exception{

    }

}

