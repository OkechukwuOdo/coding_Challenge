package com.challenge.Coding_Challenge.dto.responseDtO;

import com.challenge.Coding_Challenge.entity.Sector;
import com.challenge.Coding_Challenge.entity.UserSector;
import com.challenge.Coding_Challenge.entity.Worker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class WorkerResponseDto {
    private String fullName;
  private UserSector sector;
    }

