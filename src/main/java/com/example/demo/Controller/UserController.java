package com.example.demo.Controller;

import com.example.demo.Model.DTO.UserDTO;
import com.example.demo.Model.User;
import com.example.demo.Service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Api(value = "User controller")
public class UserController {
    @NonNull
    private final IUserService service;

    @GetMapping
    @CrossOrigin
    @ApiOperation("Get all users")
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }

    @PostMapping("/save_user")
    @CrossOrigin
    @ApiOperation(value = "Save user")
    public ResponseEntity<String> saveUser(@ApiParam(value = "UserDTO object", required = true) @RequestBody UserDTO user) {
        service.saveUser(user);
        return ResponseEntity.ok("User saved successfully");
    }

    @DeleteMapping("/delete_user/{email}")
    @CrossOrigin
    @ApiOperation(value = "Delete user")
    public ResponseEntity<String> deleteUser(@ApiParam("User`s login") @PathVariable String login) {
        service.deleteUser(login);
        return ResponseEntity.ok("User deleted successfully");
    }

    @GetMapping("/{login}")
    @CrossOrigin
    @ApiOperation(value = "Get user by login")
    public UserDTO findUserByLogin(@ApiParam("User`s login") @PathVariable String login) {
        return service.findUserByLogin(login);
    }
}
