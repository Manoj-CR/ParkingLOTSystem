package Strategy;

import Models.VehicleType;

import java.util.Date;

public interface FeeCalculatorStartegy {
    double feeCalculate(Date exitTime, Date entryTime);
}
