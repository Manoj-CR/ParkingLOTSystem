import Controller.BillController;
import Controller.TicketController;
import DTO.*;
import Models.*;
import ObjectContainer.ObjectContainer;
import Repository.ParkingLotRepository;
import Service.BillService;
import Service.TicketService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ParkingLot parkingLot=new ParkingLot();
    public static ParkingLot preInitializeData(){
        //Preinitialize Data

        List<ParkingFloor> parkingFloorList=new ArrayList<>();
        ParkingFloor parkingFloor=new ParkingFloor();
        parkingFloor.setFloorNumber(1);
        parkingFloor.setParkingFloorStatus(ParkingFloorStatus.OPEN);
        parkingFloor.setId(1);

        List<ParkingSpot> parkingSpotList=new ArrayList<>();
        for(int i=0;i<5;i++) {
            ParkingSpot parkingSpot = new ParkingSpot();
            List<VehicleType> vehicleTypes = new ArrayList<>();
            vehicleTypes.add(VehicleType.SMALL);
            vehicleTypes.add(VehicleType.MEDIUM);
            vehicleTypes.add(VehicleType.LARGE);
            parkingSpot.setSupportedVehicleTypeList(vehicleTypes);
            parkingSpot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
            parkingSpot.setId(i);
            parkingSpotList.add(parkingSpot);
        }
        parkingFloor.setParkingSpotsList(parkingSpotList);
        parkingFloorList.add(parkingFloor);

        // parking Floor List
        parkingLot.setParkingFloorsList(parkingFloorList);

        //Gate List
        List<Gate> gateList=new ArrayList<>();
        Gate gate=new Gate();
        //Gate 1:  entry gate
        gate.setGateNumber(1);
        gate.setGateStatus(GateStatus.OPEN);
        gate.setGateType(GateType.ENTRY);
        gate.setOperator(new Operator());
        gate.setId(1);
        gateList.add(gate);
        //Gate 2: exit Gate
        Gate gate2=new Gate();
        gate2.setGateNumber(2);
        gate2.setGateStatus(GateStatus.OPEN);
        gate2.setGateType(GateType.EXIT);
        gate2.setOperator(new Operator());
        gate2.setId(2);
        gateList.add(gate2);
        parkingLot.setGateList(gateList);
        parkingLot.setAddress("Test");
        parkingLot.setId(1);
        return parkingLot;
    }
    public static void main(String[] args) {
        ParkingLot parkingLot = preInitializeData();
        System.out.println("Hello to my Project");
        ObjectContainer objectContainer=new ObjectContainer();
        ParkingLotRepository parkingLotRepository=new ParkingLotRepository(parkingLot);
        parkingLot=parkingLotRepository.createParkingLot(parkingLot);
        objectContainer.registerObject("parkingLotRepository",parkingLotRepository);

        TicketService ticketService=new TicketService(objectContainer);
        objectContainer.registerObject("ticketService",ticketService);
        TicketController ticketController= new TicketController(
                (TicketService)objectContainer.getObject("ticketService"));

        GenerateTicketRequestDTO generateTicketRequestDTO=new GenerateTicketRequestDTO();

        //Bill Generation
        GenerateBillReqeustDTO generateBillReqeustDTO=new GenerateBillReqeustDTO();
        BillService billService=new BillService(objectContainer);
        objectContainer.registerObject("billService",billService);
        BillController billController=new BillController(
                (BillService) objectContainer.getObject("billService"));
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Entry Gate");
            System.out.println("2. Exit Gate");
            System.out.println(" Enter Gate Type");
            int i=sc.nextInt();
            if(i==1) {

                System.out.println("Enter Vehicle Number");
                generateTicketRequestDTO.setVehicleNumber(sc.next());
                System.out.println("Enter Gate Id");
                generateTicketRequestDTO.setGateId(sc.nextLong());
                System.out.println("Enter Vehicle Type :");
                System.out.println("1.SMALL");
                System.out.println("2.MEDIUM");
                System.out.println("3.LARGE");
                generateTicketRequestDTO.setVehicleType(VehicleType.valueOf(sc.next()));
                GenerateTicketResponseDTO generateTicketResponseDTO = ticketController.
                        generatTicket(generateTicketRequestDTO, objectContainer);
                if (generateTicketResponseDTO.getResponseStatus().equals(ReponseStatus.FAILURE)) {
                    System.out.println(generateTicketResponseDTO.getFailureMessage());
                } else {
                    System.out.println("Ticket generated Successfully:");
                    System.out.println("TicketID:" + generateTicketResponseDTO.getTicket().getId());
                    System.out.println("Vehicle Number:" + generateTicketResponseDTO.getTicket().getVehicle().
                            getVehicleNumber());
                    String isoDatePattern = "dd-MM-yyyy - HH:mm:ss";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
                    String dateString = simpleDateFormat.format(generateTicketResponseDTO.getTicket().getEntryTime());
                    System.out.println("Time of Entry :" + dateString);
                }
            }else{
                System.out.println("Enter Vehicle Number");
                generateBillReqeustDTO.setVehicleNumber(sc.next());
                System.out.println("Enter Gate Id");
                generateBillReqeustDTO.setGateId(sc.nextLong());
                GenerateBillResponseDTO generateBillResponseDTO=billController.generateBill(
                        generateBillReqeustDTO,objectContainer);
                if (generateBillResponseDTO.getResponseStatus().equals(ReponseStatus.FAILURE)) {
                    System.out.println(generateBillResponseDTO.getFailureMessage());
                } else {
                    System.out.println("Bill generated Successfully:");
                    System.out.println("Bill ID:" + generateBillResponseDTO.getBill().getId());
                    System.out.println("Vehicle Number:" + generateBillResponseDTO.getBill().
                            getTicket().getVehicle().
                            getVehicleNumber());
                    String isoDatePattern = "dd-MM-yyyy - HH:mm:ss";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
                    String dateString = simpleDateFormat.format(generateBillResponseDTO.getBill().getExitTime());
                    System.out.println("Bill Amount:" + generateBillResponseDTO.getBill().getAmount());
                    System.out.println("Time of Exit :" + dateString);
                }

            }
        }
    }
}
