package com.challenge.Coding_Challenge.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
//@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SubUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public SubUnit(String name) {
        this.name = name;
    }
}
