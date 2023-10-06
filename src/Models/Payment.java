package Models;

public class Payment extends BaseEntity{

    private int transactionId;

    private ModeofPayment modeofPayment;

    private double amount;

    private PaymentStatus paymentStatus;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public ModeofPayment getModeofPayment() {
        return modeofPayment;
    }

    public void setModeofPayment(ModeofPayment modeofPayment) {
        this.modeofPayment = modeofPayment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
