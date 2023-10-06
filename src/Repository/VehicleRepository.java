package Repository;

import Models.Vehicle;

import java.util.HashMap;

public class VehicleRepository {

    /*
    using map as a DB
     */

    private HashMap<String , Vehicle> vehicleMap;

    public VehicleRepository(){
        this.vehicleMap=new HashMap<>();
    }

    public Vehicle addVehicle(Vehicle vehicle){

        return vehicleMap.put(vehicle.getVehicleNumber(),vehicle);
    }
    public Vehicle getVehicle(String vehicleNumber){

        return vehicleMap.get(vehicleNumber);
    }

}
