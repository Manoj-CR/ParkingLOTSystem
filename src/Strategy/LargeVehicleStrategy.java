package Strategy;

import Models.VehicleType;

import java.util.Date;

public class LargeVehicleStrategy implements FeeCalculatorStartegy{
    @Override
    public double feeCalculate(Date exitTime, Date entryTime) {
        double amountPerHour=30;
        double diff=exitTime.getTime()-entryTime.getTime();
        double diffHours =  (diff / (60 * 60 * 1000));
        return diffHours*amountPerHour;
    }
}
