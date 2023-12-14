package com.challenge.Coding_Challenge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserSector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSectorId;
    private String sectorName;
    private String subSector;
    private String unit;
    private String subUnit;
//    @OneToMany(mappedBy = "userSector")
//    @OneToMany
//    private List<Worker> worker;
}
