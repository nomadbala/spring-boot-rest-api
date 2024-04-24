package com.example.demo.Service.Impl;

import com.example.demo.Model.DTO.UserDTO;
import com.example.demo.Model.LoginRequest;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public void saveUser(UserDTO userDTO) {
        User user = convertUserDTOToUser(userDTO);

        repository.save(user);
    }

    @Override
    public void deleteUser(String login) {
        repository.deleteUserByLogin(login);
    }

    @Override
    public UserDTO findUserByLogin(String login) {
        Optional<User> optionalUser = Optional.ofNullable(repository.findUserByLogin(login));
        UserDTO userDTO = null;
        if (optionalUser.isPresent()) {
            userDTO = convertUserToUserDTO(optionalUser.get());
        }
        return userDTO;
    }

    @Override
    public void login(LoginRequest loginRequest) {
        UserDTO user = findUserByLogin(loginRequest.getLogin());

        if (user != null) {
            passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
        }
    }

    private User convertUserDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getFullName());
        user.setUrlToPFP(userDTO.getUrlToPFP());
        return user;
    }

    private UserDTO convertUserToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(user.getLogin());
        userDTO.setPassword(user.getPassword());
        userDTO.setFullName(user.getFullName());
        userDTO.setUrlToPFP(user.getUrlToPFP());
        return userDTO;
    }
}
