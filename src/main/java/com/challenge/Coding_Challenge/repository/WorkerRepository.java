package com.challenge.Coding_Challenge.repository;

import com.challenge.Coding_Challenge.entity.Worker;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker,Long> {
}
