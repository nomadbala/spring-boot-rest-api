package com.example.demo.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String login;

    private String password;

    private String fullName;

    private String urlToPFP;
}
