package Models;

public class Vehicle extends BaseEntity{

    private String vehicleNumber;

    private VehicleType vehicleType;

    public Vehicle(String number, VehicleType vehicleType) {
        this.vehicleNumber=number;
        this.vehicleType=vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
