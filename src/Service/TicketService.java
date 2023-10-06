package Service;

import Models.*;

import Exception.NoParkingSpotFoundException;
import ObjectContainer.ObjectContainer;
import Repository.TicketRepository;

import java.util.Date;

public class TicketService {

    private VehicleService vehicleService;
    private GateService gateService;

    private ParkingSpotService parkingSpotService;

    private ParkingLotService parkingLotService;

    private TicketRepository ticketRepository;

    public TicketService(ObjectContainer objectContainer) {
        this.vehicleService = new VehicleService(objectContainer);
        objectContainer.registerObject("vehicleService",vehicleService);
        this.gateService = new GateService(objectContainer);
        objectContainer.registerObject("gateService",gateService);
        this.parkingSpotService = new ParkingSpotService(objectContainer);
        objectContainer.registerObject("parkingSpotService",parkingSpotService);
        this.parkingLotService = new ParkingLotService(objectContainer);
        objectContainer.registerObject("parkingLotService",parkingLotService);
        this.ticketRepository = new TicketRepository(objectContainer);
        objectContainer.registerObject("ticketRepository",ticketRepository);
    }


    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType,
                                 long gateId, ObjectContainer objectContainer) throws
            NoParkingSpotFoundException {
        /*
        Flow:

        1. Get vehicle from DB using vehicleNumber
        2. if Vehicle not found, register
      */

        Vehicle vehicle=vehicleService.getVehicle(vehicleNumber);
        if(vehicle==null){
            vehicle=vehicleService.registerVehicle(vehicleNumber,vehicleType);
        }
        Gate gate=gateService.getGate(gateId);
    //    3. Assign parking Spot
        ParkingLot parkingLot=parkingLotService.getParkingLot();
        ParkingSpot parkingSpot = parkingLotService.assignSpot(vehicle,gate);
        if(parkingSpot==null){
            throw new NoParkingSpotFoundException("Parking Spot Not Found");
        }
       // 4. Update parking Spot as Occupies
         parkingSpot=parkingSpotService.assignParkingSpot(parkingSpot,parkingLot);
      //  5. Generate Ticket
        Ticket ticket=new Ticket();
        ticket.setId(ticketRepository.getTicketHashMap().size());
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());
        ticket.setEntryTime(new Date());
        ticket.setVehicle(vehicle);
        ticket.setTicketStatus(TicketStatus.OCCUPIED);
        ticketRepository.add(ticket);
        return ticket;

    }



}
