package Controller;

import DTO.GenerateTicketRequestDTO;
import DTO.GenerateTicketResponseDTO;
import DTO.ReponseStatus;
import Models.Ticket;
import Service.TicketService;
import ObjectContainer.ObjectContainer;
import Exception.NoParkingSpotFoundException;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDTO generatTicket(GenerateTicketRequestDTO generateTicketRequestDTO,ObjectContainer objectContainer){

        try {

            Ticket ticket = ticketService.generateTicket(generateTicketRequestDTO.getVehicleNumber(),
                    generateTicketRequestDTO.getVehicleType(),
                    generateTicketRequestDTO.getGateId(), objectContainer);
            GenerateTicketResponseDTO generateTicketResponseDTO =
                    new GenerateTicketResponseDTO();
            generateTicketResponseDTO.setTicket(ticket);
            generateTicketResponseDTO.setResponseStatus(ReponseStatus.SUCCESS);
            return generateTicketResponseDTO;
        } catch (NoParkingSpotFoundException e){
            GenerateTicketResponseDTO generateTicketResponseDTO =
                    new GenerateTicketResponseDTO();
            generateTicketResponseDTO.setResponseStatus(ReponseStatus.FAILURE);
            generateTicketResponseDTO.setFailureMessage(e.getMessage());
            return generateTicketResponseDTO;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
