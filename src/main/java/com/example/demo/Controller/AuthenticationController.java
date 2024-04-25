package com.example.demo.Controller;

import com.example.demo.Model.DTO.UserDTO;
import com.example.demo.Model.LoginRequest;
import com.example.demo.Service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Api(value =  "Authentication controller")
public class AuthenticationController {
    @NonNull
    private final IUserService service;

    @PostMapping("/register")
    @ApiOperation(value = "Register user")
    public ResponseEntity<String> register(@ApiParam(value = "UserDTO object") @RequestBody UserDTO user) {
        service.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    @ApiOperation(value = "Login user")
    public ResponseEntity<String> login(@ApiParam("Login request object") @RequestBody LoginRequest request) {
        service.login(request);
        return ResponseEntity.ok("User logged in successfully");
    }
}
