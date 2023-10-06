package Repository;

import Models.*;
import ObjectContainer.ObjectContainer;

import java.util.List;
import java.util.Map;

public class ParkingSpotRepository {

    private  ParkingLotRepository parkingLotRepository;

    public ParkingSpotRepository( ObjectContainer objectContainer){
        this.parkingLotRepository= (ParkingLotRepository) objectContainer.getObject("parkingLotRepository");
    }


    public ParkingSpot updateParkingSpot(ParkingSpot parkingSpot, ParkingLot parkingLot) {
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
       return parkingLotRepository.updateParkingSpot(parkingSpot,parkingLot);
    }
}
