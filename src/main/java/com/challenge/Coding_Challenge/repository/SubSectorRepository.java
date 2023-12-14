package com.challenge.Coding_Challenge.repository;

import com.challenge.Coding_Challenge.entity.SubSector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubSectorRepository extends JpaRepository<SubSector,Long> {
    SubSector findByName(String foodAndBeverages);
    Optional<SubSector> findSubSectorByName(String name);

}
