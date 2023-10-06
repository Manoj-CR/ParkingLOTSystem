package Repository;

import Models.Gate;
import Models.GateStatus;
import Models.GateType;
import Models.Operator;
import ObjectContainer.ObjectContainer;


import java.util.HashMap;

public class GateRepository {
    private HashMap<Long , Gate> gateMap;

    private ParkingLotRepository parkingLotRepository;

    public GateRepository(ObjectContainer objectContainer){
        this.parkingLotRepository= (ParkingLotRepository)
                objectContainer.getObject("parkingLotRepository");
        this.gateMap=new HashMap<>();
    }

    public Gate addGate(Gate gate){
        return gateMap.put(gate.getId(),gate);
    }
    public Gate getGate(Long gateId){

        return parkingLotRepository.getGate(gateId);
    }
}
