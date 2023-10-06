package Models;

import java.util.List;

public class ParkingFloor extends BaseEntity{

    private int floorNumber;

    private List<ParkingSpot> parkingSpotsList;

    private ParkingFloorStatus parkingFloorStatus;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSpot> getParkingSpotsList() {
        return parkingSpotsList;
    }

    public void setParkingSpotsList(List<ParkingSpot> parkingSpotsList) {
        this.parkingSpotsList = parkingSpotsList;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }
}
