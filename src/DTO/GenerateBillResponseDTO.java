package DTO;

import Models.Bill;
import Models.Ticket;

public class GenerateBillResponseDTO {


    private Bill bill;

    private ReponseStatus responseStatus;

    private String failureMessage;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
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
