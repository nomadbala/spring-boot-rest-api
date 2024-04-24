package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class User extends AbstractEntity {
    @Column(unique = true, nullable = false)
    private String login;

    private String password;

    private String fullName;

    private String urlToPFP;

    @PrePersist
    @PreUpdate
    public void hashPassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.password = encoder.encode(password);
    }
}
