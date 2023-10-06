package Models;

import java.util.List;

public class ParkingLot extends BaseEntity{

    private List<ParkingFloor> parkingFloorsList;

    private List<Gate> gateList;

    private  String address;

    public ParkingLot(List<ParkingFloor> parkingFloorsList, List<Gate> gateList, String address) {
        this.parkingFloorsList = parkingFloorsList;
        this.gateList = gateList;
        this.address = address;
    }

    public ParkingLot() {

    }

    public List<ParkingFloor> getParkingFloorsList() {
        return parkingFloorsList;
    }

    public void setParkingFloorsList(List<ParkingFloor> parkingFloorsList) {
        this.parkingFloorsList = parkingFloorsList;
    }

    public List<Gate> getGateList() {
        return gateList;
    }

    public void setGateList(List<Gate> gateList) {
        this.gateList = gateList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
