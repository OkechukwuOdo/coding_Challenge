package com.challenge.Coding_Challenge.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
//@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sectorId;
    private String name;
    @OneToMany
    private List<SubSector> subSector;
}
