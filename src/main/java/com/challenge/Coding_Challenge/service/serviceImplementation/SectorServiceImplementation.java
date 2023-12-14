package com.challenge.Coding_Challenge.service.serviceImplementation;

import com.challenge.Coding_Challenge.dto.responseDtO.SectorResponseDto;
import com.challenge.Coding_Challenge.entity.Sector;
import com.challenge.Coding_Challenge.entity.SubSector;
import com.challenge.Coding_Challenge.entity.SubUnit;
import com.challenge.Coding_Challenge.entity.Unit;
import com.challenge.Coding_Challenge.repository.SectorRepository;
import com.challenge.Coding_Challenge.repository.SubSectorRepository;
import com.challenge.Coding_Challenge.repository.SubUnitRepository;
import com.challenge.Coding_Challenge.repository.UnitRepository;
import com.challenge.Coding_Challenge.service.SectorService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
@Slf4j
public class SectorServiceImplementation implements SectorService {
    private final SectorRepository sectorRepository;
    private final SubUnitRepository subUnitRepository;
    private final UnitRepository unitRepository;
    private final SubSectorRepository subSectorRepository;

    @Override
    public List<SectorResponseDto> allSectors() {
        List<Sector> sectorsList =sectorRepository.findAll();
        return sectorsList.stream()
                .map(this::mapSectorToResponse).toList();
    }

    private SectorResponseDto mapSectorToResponse(Sector each) {
        return SectorResponseDto.builder()
                .name(each.getName())
                .subSector(each.getSubSector())
                .build();
    }

    @PostConstruct
    @Order(0)
    public void saveManufacturingSector(){
        ArrayList<SubSector> manufacturingSubSector= new ArrayList<>();
        String[] manufacturingSubSectors={"Construction Materials", "Electronics and Optics", "Food and Beverages",
                "Furniture","Machinery","Metal Working","Plastic and Rubber","Printing","Textile and Clothing","Wood"};
        Sector manufacturing= new Sector();
        manufacturing.setName("Manufacturing");
        for (String x: manufacturingSubSectors){
            SubSector manufacturingSubSect= new SubSector();
            manufacturingSubSect.setName(x);
            manufacturingSubSector.add(manufacturingSubSect);
            subSectorRepository.save(manufacturingSubSect);
        }
        manufacturing.setSubSector(manufacturingSubSector);
        sectorRepository.save(manufacturing);

    }
    @PostConstruct
    @Order(1)
    public void foodAndBeveragesSubSector(){
        ArrayList<Unit> foodAndBeveragesUnitList= new ArrayList<>();
        String[] foodAndBeveragesUnits={"Backer and Confectionery product", "Beverages", "Fish and Fish products",
                "Meat and product", "Milk and Diary", "Sweet and Snack food", "Others"};
        for (String units:foodAndBeveragesUnits){
            Unit unit=new Unit();
            unit.setName(units);
            foodAndBeveragesUnitList.add(unit);
            unitRepository.save(unit);
        }
        SubSector foodAndBeverages= subSectorRepository.findByName("Food and Beverages");
        foodAndBeverages.setUnit(foodAndBeveragesUnitList);
        subSectorRepository.save(foodAndBeverages);


    }
    @PostConstruct
    @Order(2)
    public void furniture() {
//        ArrayList<Unit> furnitureUnitList = new ArrayList<>();
//        String[] furnitureUnits = {"Bathroom/sauna", "Bedroom", "Children room", "Kitchen", "living room",
//                "office", "Other(furniture)", "Outdoor", "project furniture"};
//        for (String units : furnitureUnits) {
//            Unit unit = new Unit();
//            unit.setName(units);
//            furnitureUnitList.add(unit);
//            unitRepository.save(unit);
//        }
//        SubSector furniture_ = subSectorRepository.findSubSectorByName("Furniture")
//                .orElseThrow(()->new RuntimeException("Furniture is not found"));
//        furniture_.setUnit(furnitureUnitList);
//        subSectorRepository.save(furniture_);
    }
    @PostConstruct
    @Order(1)
    public void machinery() {
        ArrayList<Unit> machineryUnitList = new ArrayList<>();
        String[] machineryUnits = {"Machinery Component", "Machinery Equipment/tool", "Manufacture of machinery", "Maritime","Metal Structure",
                "Other","Repair and Mentainance Service"};
        for (String units : machineryUnits) {
            Unit unit = new Unit();
            unit.setName(units);
            machineryUnitList.add(unit);
            unitRepository.save(unit);
        }
        SubSector machinery = subSectorRepository.findSubSectorByName("Machinery")
                .orElseThrow(()->new RuntimeException("Machinery not found"));;
        machinery.setUnit(machineryUnitList);
        subSectorRepository.save(machinery);

        Unit marine = unitRepository.findByName("Maritime");
        ArrayList<SubUnit> maritinSubUnitList= new ArrayList<>();
        String[] maritimeSubUnit = {"Aluminium and steel workbook", "Boat/Yatch building", "Ship repair and conversion"};
        for (String subUnit: maritimeSubUnit){
            SubUnit subUnits= new SubUnit();
            subUnits.setName(subUnit);
            maritinSubUnitList.add(subUnits);
            subUnitRepository.save(subUnits);
        }
        marine.setSubUnit(maritinSubUnitList);
        unitRepository.save(marine);

    }
    @PostConstruct
    @Order(2)
    public void metalWorking() {
        ArrayList<Unit> metalWorkUnitList = new ArrayList<>();
        String[] metalWorkUnits = {"Construction of metal structure", "House and Building",
                "Metal product", "Metal works","Metal Structure"};
        for (String units : metalWorkUnits){
            Unit unit = new Unit();
            unit.setName(units);
            metalWorkUnitList.add(unit);
            unitRepository.save(unit);
        }
        SubSector metalWork = subSectorRepository.findByName("Metal Working");
        metalWork.setUnit(metalWorkUnitList);
        subSectorRepository.save(metalWork);

        Unit metalWorks= unitRepository.findByName("Metal works");
        ArrayList<SubUnit> metalWorksSubUnitList= new ArrayList<>();
        String[] metalWorksUnit = {"CNC machinery","Forgings,Fasterne","Gass, Plasma,lasser cutting","MIG,TIG,Aluminiu welding"};
        for (String subUnit: metalWorksUnit){
            SubUnit subUnits= new SubUnit();
            subUnits.setName(subUnit);
            metalWorksSubUnitList.add(subUnits);
            subUnitRepository.save(subUnits);
        }
        metalWorks.setSubUnit(metalWorksSubUnitList);
        unitRepository.save(metalWorks);

    }
    @PostConstruct
    @Order(2)
    public void plasticAndRubberSector() {
        ArrayList<Unit> plasticAndRubberSectorUnitList = new ArrayList<>();
        String[] plasticAndRubberSectorUnits= {"packaging", "plastic goods", "plastic processing Technology"};
        for (String units :plasticAndRubberSectorUnits ){
            Unit unit = new Unit();
            unit.setName(units);
            plasticAndRubberSectorUnitList.add(unit);
            unitRepository.save(unit);
        }
        SubSector plasticAndRubber_ = subSectorRepository.findByName("Plastic and Rubber");
        plasticAndRubber_.setUnit(plasticAndRubberSectorUnitList);
        subSectorRepository.save(plasticAndRubber_);

        Unit plasticTech= unitRepository.findByName("plastic processing Technology");
        ArrayList<SubUnit> plasticPTechSubUnitList= new ArrayList<>();
        String[] plasticPTech = {"Blowing","Moulding","Plastic welding processing","plastic profile"};
        for (String subUnit: plasticPTech){
            SubUnit subUnits= new SubUnit();
            subUnits.setName(subUnit);
            plasticPTechSubUnitList.add(subUnits);
            subUnitRepository.save(subUnits);
        }
        plasticTech.setSubUnit(plasticPTechSubUnitList);
        unitRepository.save(plasticTech);
    }
    @PostConstruct
    @Order(1)
    public void printingSector() {
        ArrayList<Unit> printingSectorUnitList = new ArrayList<>();
        String[] plasticAndRubberSectorUnits= {"Advertising","Book/Prodical printing","Label and packaging printing"};
        for (String units :plasticAndRubberSectorUnits ){
            Unit unit = new Unit();
            unit.setName(units);
            printingSectorUnitList.add(unit);
            unitRepository.save(unit);
        }
        SubSector printingSubSector = subSectorRepository.findByName("Printing");
        printingSubSector.setUnit(printingSectorUnitList);
        subSectorRepository.save(printingSubSector);
    }
    @PostConstruct
    @Order(2)
    public void textileAndClothing() {
        ArrayList<Unit> textileAndClothingUnitList = new ArrayList<>();
        String[] textileAndClothingSectorUnits= {"Clothing","Textile"};
        for (String units:textileAndClothingSectorUnits){
            Unit unit = new Unit();
            unit.setName(units);
            textileAndClothingUnitList.add(unit);
            unitRepository.save(unit);
        }
        SubSector textileAndClothing = subSectorRepository.findByName("Textile and Clothing");
        textileAndClothing.setUnit(textileAndClothingUnitList);
        subSectorRepository.save(textileAndClothing);
    }
    @PostConstruct
    @Order(2)
    public void wood() {
        ArrayList<Unit> woodUnitList = new ArrayList<>();
        String[] woodSectorUnits= {"Other(wood)","Wooden Building","Wooden House"};
        for (String units:woodSectorUnits){
            Unit unit = new Unit();
            unit.setName(units);
            woodUnitList.add(unit);
            unitRepository.save(unit);
        }
        SubSector wood = subSectorRepository.findByName("Wood");
        wood.setUnit(woodUnitList);
        subSectorRepository.save(wood);
    }
    @PostConstruct
    public void saveService(){
        ArrayList<SubSector> serviceSubSectorsList= new ArrayList<>();
        String[] serviceSubSectors={"Business", "Engineering", "Information Technology and Communication","Tourism", "Translation Service",
                "Transport and Logistics"};
        Sector service= new Sector();
        service.setName("Service");
        for (String x: serviceSubSectors){
            SubSector serviceSubSector= new SubSector();
            serviceSubSector.setName(x);
            serviceSubSectorsList.add(serviceSubSector);
            subSectorRepository.save(serviceSubSector);
        }
        service.setSubSector(serviceSubSectorsList);
        sectorRepository.save(service);

    }

    @PostConstruct
    @Order(3)
    public void informationTechComm() {
        ArrayList<Unit> inforUnitList = new ArrayList<>();
        String[] woodSectorUnits= {"Data processing, Web portal,E-marketing",
                "Programing, consultancy","Software,Hardware", "Telecommunications"};
        for (String units:woodSectorUnits){
            Unit unit = new Unit();
            unit.setName(units);
            inforUnitList.add(unit);
            unitRepository.save(unit);
        }
        SubSector iCT = subSectorRepository.findByName("Information Technology and Communication");
        iCT.setUnit(inforUnitList);
        subSectorRepository.save(iCT);
    }

    @PostConstruct
    @Order(3)
    public void transAndLogic() {
        ArrayList<Unit> inforUnitList = new ArrayList<>();
        String[] transAndLogicSectorUnits= {"Air","Rail", "Road","Water"};
        for (String units: transAndLogicSectorUnits){
            Unit unit = new Unit();
            unit.setName(units);
            inforUnitList.add(unit);
            unitRepository.save(unit);
        }
        SubSector transAndLogic = subSectorRepository.findByName("Transport and Logistics");
        transAndLogic.setUnit(inforUnitList);
        subSectorRepository.save(transAndLogic);
    }


    @PostConstruct
    public void saveOtherSector(){
        ArrayList<SubSector> otherSubSectorList= new ArrayList<>();
        String[] otherSubSectors={"Creative Industry", "Energy Technology","Environment"};
        Sector otherSector= new Sector();
        otherSector.setName("Others");
        for (String x: otherSubSectors){
            SubSector otherSubSector= new SubSector();
            otherSubSector.setName(x);
            otherSubSectorList.add(otherSubSector);
            subSectorRepository.save(otherSubSector);
        }
        otherSector.setSubSector(otherSubSectorList);
        sectorRepository.save(otherSector);

    }


}
