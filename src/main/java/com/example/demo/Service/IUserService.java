package com.example.demo.Service;

import com.example.demo.Model.DTO.UserDTO;
import com.example.demo.Model.LoginRequest;
import com.example.demo.Model.User;

import java.util.List;

public interface IUserService {
    List<User> findAllUsers();

    void saveUser(UserDTO user);

    void deleteUser(String login);

    UserDTO findUserByLogin(String login);

    void login(LoginRequest loginRequest);
}
