package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Request extends AbstractEntity {
    private String product;

    private int quantity;

    private String deliveryAddress;

    private String phoneNumber;
}
