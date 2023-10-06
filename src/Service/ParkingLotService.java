package Service;

import Models.Gate;
import Models.ParkingLot;
import Models.ParkingSpot;
import Models.Vehicle;
import ObjectContainer.ObjectContainer;
import Repository.ParkingLotRepository;
import Strategy.RandomParkingLotSpotAssignmentStrategy;
import Strategy.SpotAssignemntStartegy;

import java.util.List;

public class ParkingLotService {

    private SpotAssignemntStartegy spotAssignemntStartegy;

    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ObjectContainer objectContainer) {
        this.spotAssignemntStartegy = new RandomParkingLotSpotAssignmentStrategy();
        this.parkingLotRepository = (ParkingLotRepository) objectContainer.getObject("parkingLotRepository");
        objectContainer.registerObject("spotAssignemntStartegy",spotAssignemntStartegy);

    }

    public ParkingSpot assignSpot(Vehicle vehicle, Gate gate) {

        List<List<ParkingSpot>> parkingSpotListList=parkingLotRepository.getAllParkingSpot();

        return spotAssignemntStartegy.assignSpot(vehicle,gate,parkingSpotListList);

    }

    public ParkingLot getParkingLot() {
       return  parkingLotRepository.getParkingLot();
    }
}
