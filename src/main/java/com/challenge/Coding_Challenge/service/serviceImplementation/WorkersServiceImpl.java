package com.challenge.Coding_Challenge.service.serviceImplementation;

import com.challenge.Coding_Challenge.dto.requestDTO.WorkerRequestDto;
import com.challenge.Coding_Challenge.dto.responseDtO.WorkerResponseDto;
import com.challenge.Coding_Challenge.entity.*;
import com.challenge.Coding_Challenge.repository.*;
import com.challenge.Coding_Challenge.service.WorkersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class WorkersServiceImpl implements WorkersService {
    private final WorkerRepository workerRepository;
    private final SectorRepository sectorRepository;
    private final SubUnitRepository subUnitRepository;
    private final UnitRepository unitRepository;
    private final SubSectorRepository subSectorRepository;
    private final UserSectorRepository userSectorRepository;

    @Override
    public WorkerResponseDto creatUser(WorkerRequestDto requestDto) {
        if (requestDto.isAgreed()) {
            UserSector userSector = getUserSector(requestDto);
            Worker worker = Worker.builder()
                    .fullName(requestDto.getFullName())
                    .agreed(true)
                    .userSector(userSector)
                    .build();
            Worker newWorker = workerRepository.save(worker);
            return WorkerResponseDto.builder()
                    .fullName(newWorker.getFullName())
                    .sector(newWorker.getUserSector())
                    .build();

        }
        return null;
    }

    private UserSector getUserSector(WorkerRequestDto requestDto) {
        UserSector userSector= new UserSector();
        if (!requestDto.getSector().isEmpty()){
            userSector.setSectorName(sectorRepository.findSectorByName(requestDto.getSector()).getName());
        }
        if (!requestDto.getSubSector().isEmpty()){
            userSector.setSubSector(subSectorRepository.findByName(requestDto.getSubSector()).getName());
        }
        if (!requestDto.getUnit().isEmpty()){
            userSector.setUnit(unitRepository.findByName(requestDto.getUnit()).getName());
        }
        if (!requestDto.getSubUnit().isEmpty()){
            userSector.setSubUnit(subUnitRepository.findSubUnitByName(requestDto.getSubUnit()).getName());
        }

        return userSectorRepository.save(userSector);
    }

    @Override
    public WorkerResponseDto editUser(Long userId, WorkerRequestDto workerRequestDto) {
        Worker worker= workerRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User does not exist"));
        worker.setFullName(workerRequestDto.getFullName());
        worker.setUserSector(getUserSector(workerRequestDto));

        Worker newWorker= workerRepository.save(worker);
        return WorkerResponseDto.builder()
                .fullName(newWorker.getFullName())
                .sector(newWorker.getUserSector())
                .build();
    }


    @Override
    public List<WorkerResponseDto> allWorkers() {

        log.info("{List of workers}",workerRepository.findById(1L));
        log.info("finding all workers");
        List<Worker> workers= workerRepository.findAll();
        return workers.stream().map(this::mapWorkerResp).toList();
    }

    private WorkerResponseDto mapWorkerResp(Worker each) {
   return WorkerResponseDto.builder()
           .fullName(each.getFullName())
           .sector(each.getUserSector())
           .build();
    }


}
