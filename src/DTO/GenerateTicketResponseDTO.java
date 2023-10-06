package DTO;

import Models.Ticket;

public class GenerateTicketResponseDTO {

    private Ticket ticket;

    private ReponseStatus responseStatus;

    private String failureMessage;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ReponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ReponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }
}
