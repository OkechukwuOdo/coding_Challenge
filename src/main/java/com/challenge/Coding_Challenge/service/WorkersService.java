package com.challenge.Coding_Challenge.service;
import com.challenge.Coding_Challenge.dto.requestDTO.WorkerRequestDto;
import com.challenge.Coding_Challenge.dto.responseDtO.SectorResponseDto;
import com.challenge.Coding_Challenge.dto.responseDtO.WorkerResponseDto;
import com.challenge.Coding_Challenge.entity.Worker;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface WorkersService {
    WorkerResponseDto creatUser(WorkerRequestDto requestDto);
    WorkerResponseDto editUser(Long userId, WorkerRequestDto requestDto);


    List<WorkerResponseDto> allWorkers();
}
