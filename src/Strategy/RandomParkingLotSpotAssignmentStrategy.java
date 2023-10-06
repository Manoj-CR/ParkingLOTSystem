package Strategy;

import Models.Gate;
import Models.ParkingSpot;
import Models.ParkingSpotStatus;
import Models.Vehicle;

import java.util.List;

public class RandomParkingLotSpotAssignmentStrategy implements SpotAssignemntStartegy {


    @Override
    public ParkingSpot assignSpot(Vehicle vehicle, Gate gate, List<List<ParkingSpot>> parkingSpotListList) {

        for(List<ParkingSpot> parkingSpotLists:parkingSpotListList) {
            for (ParkingSpot parkingSpot : parkingSpotLists) {
                if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)
                        && parkingSpot.getSupportedVehicleTypeList().contains(vehicle.getVehicleType())) {
                    return parkingSpot;
                }
            }
        }
    return null;
    }
}
