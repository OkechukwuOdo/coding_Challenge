package com.challenge.Coding_Challenge.repository;

import com.challenge.Coding_Challenge.entity.SubUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubUnitRepository extends JpaRepository<SubUnit,Long> {
    SubUnit findSubUnitByName(String name);
}
