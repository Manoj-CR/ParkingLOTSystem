package Repository;

import Models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLotRepository {
    
    private ParkingLot parkingLot;

    private HashMap<Long , ParkingLot> parkingLotHashMap;
    public ParkingLotRepository(ParkingLot parkingLot){
        this.parkingLotHashMap=new HashMap<>();
        this.parkingLot=parkingLot;

    }
    public ParkingLot createParkingLot(List<ParkingFloor> parkingFloorList, List<Gate> gateList, 
                                       String address, BaseEntity baseEntity){
       return new ParkingLot(parkingFloorList,gateList,address);
    }
    public List<List<ParkingSpot>> getAllParkingSpot() {
       
        List<List<ParkingSpot>> parkingSpotListList = new ArrayList<>();
        List<ParkingFloor> parkingFloorList=parkingLot.getParkingFloorsList();
        for(ParkingFloor parkingFloor:parkingFloorList) {
            List<ParkingSpot> parkingSpotList = parkingFloor.getParkingSpotsList();
            parkingSpotListList.add(parkingSpotList);
        }
        return parkingSpotListList;
    }
    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        return parkingLotHashMap.put(parkingLot.getId(),parkingLot);
    }

    public ParkingLot getParkingLot() {
        return parkingLotHashMap.get(1L);
    }

    public ParkingSpot updateParkingSpot(ParkingSpot parkingSpot,ParkingLot parkingLot) {

        List<ParkingFloor> parkingFloorList=parkingLot.getParkingFloorsList();
        for(ParkingFloor parkingFloor:parkingFloorList) {
            List<ParkingSpot> parkingSpotList = parkingFloor.getParkingSpotsList();
            for(ParkingSpot parkingSpot1:parkingSpotList) {
                if (parkingSpot1.getId() == parkingSpot.getId()) {
                    parkingSpot1.setParkingSpotStatus(parkingSpot.getParkingSpotStatus());
                }
            }
        }
        parkingLot.setParkingFloorsList(parkingFloorList);
        createParkingLot(parkingLot);
        return parkingSpot;
    }

    public Gate getGate(Long gateId) {
        ParkingLot parkingLot=getParkingLot();
        List<Gate> gateList=parkingLot.getGateList();
        for(Gate gate:gateList){
            if(gate.getGateNumber()==gateId){
                return gate;
            }
        }
        return null;


    }
}
