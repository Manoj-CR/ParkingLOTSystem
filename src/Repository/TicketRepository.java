package Repository;

import Models.Ticket;
import Models.TicketStatus;
import ObjectContainer.ObjectContainer;

import java.util.HashMap;

public class TicketRepository {
    private HashMap<Long, Ticket> ticketHashMap;

    public TicketRepository(ObjectContainer objectContainer){

        this.ticketHashMap=new HashMap<>();
    }


    public HashMap<Long, Ticket> getTicketHashMap() {

        return ticketHashMap;
    }

    public void add(Ticket ticket) {

        ticketHashMap.put(ticket.getId(),ticket);
    }

    public Ticket getTicketBasedOnVehicleNumber(String vehicleNumber) {
        HashMap<Long, Ticket> ticketHashMap = getTicketHashMap();
        for (Ticket ticket : ticketHashMap.values()) {
            if (ticket.getVehicle().getVehicleNumber().equals(vehicleNumber) &&
                    ticket.getTicketStatus().equals(TicketStatus.OCCUPIED)) {
                return ticket;
            }
        }
        return null;
    }

    public void setTicketStatus(Ticket ticket) {
        ticketHashMap.put(ticket.getId(), ticket);
    }
}
