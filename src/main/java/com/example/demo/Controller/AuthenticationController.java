package com.example.demo.Controller;

import com.example.demo.Model.DTO.UserDTO;
import com.example.demo.Model.LoginRequest;
import com.example.demo.Service.IUserService;
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
public class AuthenticationController {
    @NonNull
    private final IUserService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO user) {
        service.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        service.login(request);
        return ResponseEntity.ok("User logged in successfully");
    }
}
