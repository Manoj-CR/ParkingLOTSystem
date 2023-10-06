package Service;

import Factory.VehicleFeeFactory;
import Models.VehicleType;
import Strategy.FeeCalculatorStartegy;

import java.util.Date;

public class FeeCalculationService {

    double billAmount(Date exitTime, Date entryTime, VehicleType vehicleType) {
        VehicleFeeFactory vehicleFeeFactory=new VehicleFeeFactory();
        FeeCalculatorStartegy feeCalculatorStartegy =vehicleFeeFactory.getVehicle(vehicleType);
        return feeCalculatorStartegy.feeCalculate(exitTime,entryTime);

    }
}
