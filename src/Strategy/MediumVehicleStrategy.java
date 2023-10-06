package Strategy;

import Models.VehicleType;

import java.util.Date;

public class MediumVehicleStrategy implements FeeCalculatorStartegy{
    @Override
    public double feeCalculate(Date exitTime, Date entryTime) {
        double amountPerHour=20;
        double diff=exitTime.getTime()-entryTime.getTime();
        double diffHours = (diff / (60 * 60 * 1000));
        return diffHours*amountPerHour;
    }
}
