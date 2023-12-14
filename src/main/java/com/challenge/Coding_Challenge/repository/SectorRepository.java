package com.challenge.Coding_Challenge.repository;

import com.challenge.Coding_Challenge.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<Sector,Long> {
    Sector findSectorByName(String name);
}
