package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class News extends AbstractEntity {
    private String title;

    private String content;
}
