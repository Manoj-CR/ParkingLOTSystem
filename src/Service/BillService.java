package Service;

import Factory.VehicleFeeFactory;
import Models.*;
import ObjectContainer.ObjectContainer;
import Repository.BillRepository;
import Repository.GateRepository;
import Repository.TicketRepository;
import Exception.*;
import Strategy.FeeCalculatorStartegy;

import java.util.Date;
import java.util.Scanner;

public class BillService {

    private TicketRepository ticketRepository;
    private GateRepository gateRepository;

    private BillRepository billRepository;

    private PaymentService paymentService;

    private FeeCalculationService feeCalculationService;

    public BillService(ObjectContainer objectContainer) {
        this.ticketRepository= (TicketRepository)
                objectContainer.getObject("ticketRepository");
        this.gateRepository = (GateRepository) objectContainer.getObject("gateRepository");
        this.paymentService=new PaymentService();
        objectContainer.registerObject("paymentService",paymentService);
        this.billRepository=new BillRepository();
        objectContainer.registerObject("billRepository",billRepository);
        this.feeCalculationService=new FeeCalculationService();
        objectContainer.registerObject("feeCalculationService",feeCalculationService);

    }

    public Bill generateBill(String vehicleNumber, long gateId,
                             ObjectContainer objectContainer) throws TicketNotFoundException, PaymentUnSucessfullException {
        Bill bill=new Bill();
        try {
            Ticket ticket = ticketRepository.getTicketBasedOnVehicleNumber(vehicleNumber);
            if (ticket == null) {
                throw new TicketNotFoundException("No Ticket Found");
            }else{
                bill.setTicket(ticket);
                Gate gate=gateRepository.getGate(gateId);
                bill.setGate(gate);
                bill.setOperator(gate.getOperator());
                bill.setExitTime(new Date());
                double amount = feeCalculationService.billAmount(bill.getExitTime(),ticket.getEntryTime(),
                        ticket.getVehicle().getVehicleType());
                bill.setAmount(amount);

                // implement payment status
                System.out.println("Choose Method of Payment");
                System.out.println("1. PayPal");
                System.out.println("2. RazorPay");
                Scanner sc=new Scanner(System.in);
                int option=sc.nextInt();
                Payment payment=paymentService.getDetails(amount,option);
                if(payment==null){
                    bill.setBillStatus(BillStatus.FAILURE);
                    throw new PaymentUnSucessfullException("Payment UnSuccessful. " +
                            "Kindly try again");
                }else{
                    bill.setBillStatus(BillStatus.SUCESS);
                    ticket.setTicketStatus(TicketStatus.CLOSED);
                    ticketRepository.setTicketStatus(ticket);
                }

                bill.setPaymentList(payment);
                billRepository.saveBill(bill);
                return bill;
            }
        }catch (TicketNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
