package Models;

import java.util.List;

public class ParkingSpot extends BaseEntity {
    private List<VehicleType> supportedVehicleTypeList;

    private ParkingFloor parkingFloor;

    private ParkingSpotStatus parkingSpotStatus;
    private int parkingSpotNumber;

    public List<VehicleType> getSupportedVehicleTypeList() {
        return supportedVehicleTypeList;
    }

    public void setSupportedVehicleTypeList(List<VehicleType> supportedVehicleTypeList) {
        this.supportedVehicleTypeList = supportedVehicleTypeList;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public int getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(int parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }
}
