package Service;

import Models.Vehicle;
import Models.VehicleType;
import ObjectContainer.ObjectContainer;
import Repository.VehicleRepository;

public class VehicleService {

   private VehicleRepository vehicleRepository;

   public VehicleService(ObjectContainer objectContainer) {
      this.vehicleRepository = new VehicleRepository();
      objectContainer.registerObject("vehicleRepository",vehicleRepository);
   }

   public Vehicle registerVehicle(String number, VehicleType vehicleType){
      Vehicle vehicle=new Vehicle(number,vehicleType);
      vehicleRepository.addVehicle(vehicle);
      return vehicle;
   }

   public Vehicle getVehicle(String number){
     return vehicleRepository.getVehicle(number);
   }

}
