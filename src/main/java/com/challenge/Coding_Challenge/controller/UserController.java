package com.challenge.Coding_Challenge.controller;

import com.challenge.Coding_Challenge.dto.requestDTO.WorkerRequestDto;
import com.challenge.Coding_Challenge.dto.responseDtO.SectorResponseDto;
import com.challenge.Coding_Challenge.dto.responseDtO.WorkerResponseDto;
import com.challenge.Coding_Challenge.entity.Worker;
import com.challenge.Coding_Challenge.service.SectorService;
import com.challenge.Coding_Challenge.service.WorkersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final SectorService service;
    private final WorkersService workersService;


    @GetMapping("/all-sectors")
    public List<SectorResponseDto> allSectors(){
        return service.allSectors();
    }

    @PostMapping("/save-user")
    public WorkerResponseDto saveUser(@Validated @RequestBody WorkerRequestDto requestDto){
        return workersService.creatUser(requestDto);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<WorkerResponseDto> editUser(@PathVariable Long userId, @Validated @RequestBody WorkerRequestDto requestDto){
        return ResponseEntity.ok(workersService.editUser(userId,requestDto));
    }
    @GetMapping("/all-workers")
    public List<WorkerResponseDto> allWorkers(){
        return workersService.allWorkers();
    }
}
