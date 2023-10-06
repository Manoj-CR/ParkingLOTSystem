package Models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseEntity{

    private Date exitTime;
    private Ticket ticket;
    private double amount;
    private Operator operator;
    private Gate gate;
    private BillStatus billStatus;
    private Payment paymentList;

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public Payment getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(Payment paymentList) {
        this.paymentList = paymentList;
    }
}
