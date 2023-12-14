package com.challenge.Coding_Challenge.dto.responseDtO;

import com.challenge.Coding_Challenge.entity.SubSector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@Data
//@RequiredArgsConstructor
@AllArgsConstructor
public class SectorResponseDto {
    private String name;
    private List<SubSector> subSector;
}
