package com.challenge.Coding_Challenge;

import com.challenge.Coding_Challenge.entity.SubSector;
import com.challenge.Coding_Challenge.entity.Unit;
import com.challenge.Coding_Challenge.repository.SubSectorRepository;
import com.challenge.Coding_Challenge.repository.SubUnitRepository;
import com.challenge.Coding_Challenge.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@RequiredArgsConstructor
@SpringBootApplication
public class CodingChallengeApplication {
	private final UnitRepository unitRepository;
	private final SubSectorRepository subSectorRepository;

	public static void main(String[] args) {
		SpringApplication.run(CodingChallengeApplication.class, args);
	}
	@Bean
	public CommandLineRunner dataLoader() {
		return args -> {
			ArrayList<Unit> furnitureUnitList = new ArrayList<>();
			String[] furnitureUnits = {"Bathroom/sauna", "Bedroom", "Children room", "Kitchen", "living room",
					"office", "Other(furniture)", "Outdoor", "project furniture"};
			for (String units : furnitureUnits) {
				Unit unit = new Unit();
				unit.setName(units);
				furnitureUnitList.add(unit);
				unitRepository.save(unit);
			}
			SubSector furniture_ = subSectorRepository.findSubSectorByName("Furniture")
					.orElseThrow(()->new RuntimeException("Furniture is not found"));
			furniture_.setUnit(furnitureUnitList);
			subSectorRepository.save(furniture_);

		};
	}
}


