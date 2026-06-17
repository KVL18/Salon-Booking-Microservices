package com.kvl.service;


import com.kvl.payload.dto.*;
import com.kvl.payload.response.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.management.relation.RoleStatus;
import java.security.PublicKey;
import java.sql.SQLOutput;
import java.util.List;


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
    private static  final String clientId = "3bbb89c2-9c72-4bc4-93d7-869a392b4356";


    private final RestTemplate restTemplate;

    public void createUser(SignupDTO signupDTO) throws Exception{

        String ACCESS_TOKEN = getAdminAccessToken(
                username,
                password,
                GRANT_TYPE,null).getAccessToken();

        Credential credential = new Credential();
        credential.setTemporary(false);
        credential.setType(password);
        credential.setValue(signupDTO.getPassword());

        UserRequest userRequest = new UserRequest();
        userRequest .setUsername(signupDTO.getUsername());
        userRequest.setEmail(signupDTO.getEmail());
        userRequest.setEnabled(true);
        userRequest.setLastName(signupDTO.getLastName());
        userRequest.setFirstName(signupDTO.getFirstName());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(ACCESS_TOKEN);

        HttpEntity<UserRequest> requestEntity = new HttpEntity<>(userRequest,headers);

        ResponseEntity<String> response = restTemplate.exchange(
                KEYCLOAK_ADMIN_API,
                HttpMethod.POST,
                requestEntity,
                String.class
        );
        if(response.getStatusCode() == HttpStatus.CREATED){
            System.out.println("user created successfully");

            KeycloakUserDTO user= fetchFirstUserByUsername(signupDTO.getUsername(),
                    ACCESS_TOKEN);

            KeycloakRole role = getRoleByName(clientId,ACCESS_TOKEN,signupDTO.g)

            assignRoleToUser(user.getId(),
                    clientId,
                    roles,
                    ACCESS_TOKEN
            );

        }

    }

    public TokenResponse getAdminAccessToken(String username, String password,
                                             String grantType,
                                             String refreshToken){
        return new TokenResponse();
    }

    public KeycloakRole getRoleByName(String getClientId,
                                      String token,
                                      String role){
        return null;
    }

    public KeycloakUserDTO fetchFirstUserByUsername(String username, String token){
        return null;
    }

    public void assignRoleToUser(String userId,
                                 String ClientId,
                                 List<KeycloakRole> roles,
                                 String token){

    }


}

