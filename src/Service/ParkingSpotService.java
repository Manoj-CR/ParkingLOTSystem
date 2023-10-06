package Service;

import Models.ParkingLot;
import Models.ParkingSpot;
import ObjectContainer.ObjectContainer;
import Repository.ParkingSpotRepository;

public class ParkingSpotService {


    private ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ObjectContainer objectContainer) {

        this.parkingSpotRepository = new ParkingSpotRepository(objectContainer);
        objectContainer.registerObject("parkingSpotRepository",parkingSpotRepository);
    }

    public ParkingSpot assignParkingSpot(ParkingSpot parkingSpot, ParkingLot parkingLot) {
            //TO DO IMPLEMENT with Repo
        return parkingSpotRepository.updateParkingSpot(parkingSpot,parkingLot);

    }


}
