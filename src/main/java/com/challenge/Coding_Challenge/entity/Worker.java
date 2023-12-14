package com.challenge.Coding_Challenge.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long WorkerId;
    private String fullName;
    @ManyToOne
    @JoinColumn(name = "userSector_id")
    private UserSector userSector;
    private boolean agreed;
}
