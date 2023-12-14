package com.challenge.Coding_Challenge.service;

import com.challenge.Coding_Challenge.dto.requestDTO.SectorRequestDTO;
import com.challenge.Coding_Challenge.dto.requestDTO.WorkerRequestDto;
import com.challenge.Coding_Challenge.dto.responseDtO.SectorResponseDto;
import com.challenge.Coding_Challenge.dto.responseDtO.WorkerResponseDto;

import java.util.List;

public interface SectorService {
//    SectorResponseDto uploadSectors(SectorRequestDTO requestDTO);

    List<SectorResponseDto> allSectors();

//    WorkerResponseDto saveUser(WorkerRequestDto requestDto);

}
