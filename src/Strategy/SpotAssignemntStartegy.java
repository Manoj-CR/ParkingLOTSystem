package Strategy;

import Models.Gate;
import Models.ParkingSpot;
import Models.Vehicle;

import java.util.List;

public interface SpotAssignemntStartegy {

    ParkingSpot assignSpot(Vehicle vehicle, Gate gate, List<List<ParkingSpot>> parkingSpotList);

}
