package com.example.demo.Controller;

import com.example.demo.Model.DTO.UserDTO;
import com.example.demo.Model.User;
import com.example.demo.Service.IUserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    @NonNull
    private final IUserService service;

    @GetMapping
    @CrossOrigin
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }

    @PostMapping("/save_user")
    @CrossOrigin
    public ResponseEntity<String> saveUser(@RequestBody UserDTO user) {
        service.saveUser(user);
        return ResponseEntity.ok("User saved successfully");
    }

    @DeleteMapping("/delete_user/{email}")
    @CrossOrigin
    public ResponseEntity<String> deleteUser(@PathVariable String login) {
        service.deleteUser(login);
        return ResponseEntity.ok("User deleted successfully");
    }

    @GetMapping("/{login}")
    @CrossOrigin
    public UserDTO findUserByLogin(@PathVariable String login) {
        return service.findUserByLogin(login);
    }
}
