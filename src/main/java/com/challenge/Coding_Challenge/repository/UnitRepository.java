package com.challenge.Coding_Challenge.repository;

import com.challenge.Coding_Challenge.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit,Long> {
    Unit findByName(String maritime);

}
