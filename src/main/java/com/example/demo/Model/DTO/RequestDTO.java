package com.example.demo.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class RequestDTO {
    private String product;

    private int quantity;

    private String deliveryAddress;

    private String phoneNumber;
}
