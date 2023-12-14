package com.challenge.Coding_Challenge.dto.requestDTO;

import lombok.Data;

@Data
public class WorkerRequestDto {
    private String fullName;
    private String sector="";
    private String subSector="";
    private String unit="";
    private String subUnit="";
    private boolean agreed;
}
