package Factory;

import Models.VehicleType;
import Strategy.FeeCalculatorStartegy;
import Strategy.LargeVehicleStrategy;
import Strategy.MediumVehicleStrategy;
import Strategy.SmallVehicleStrategy;

public class VehicleFeeFactory {
    public FeeCalculatorStartegy getVehicle(VehicleType vehicleType) {
        if(VehicleType.SMALL.equals(vehicleType)){
            return new SmallVehicleStrategy();
        } else if (VehicleType.MEDIUM.equals(vehicleType)) {
            return new MediumVehicleStrategy();
        }else{
            return new LargeVehicleStrategy();
        }
    }
}
