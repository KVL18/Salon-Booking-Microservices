package com.kvl.service.client;


import com.kvl.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "USER-SERVICE",
        path = "/api/users"
)
public interface UserFeignClient {

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById
            (@PathVariable Long id)
            throws Exception;


    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getUserProfile( @RequestHeader("Authorization") String jwt)
            throws Exception;


}
