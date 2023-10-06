package Adapter;

import Models.ModeofPayment;
import Models.PaymentStatus;

public class PayPal {

    private static int transactionId;
    private PaymentStatus paymentStatus;
    private ModeofPayment modeofPayment;

    public int getTransactionID() {
        return transactionId;
    }

    public void setTransactionID(int transactionID) {
        transactionId = transactionID;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public ModeofPayment getModeofPayment() {
        return modeofPayment;
    }

    public void setModeofPayment(ModeofPayment modeofPayment) {
        this.modeofPayment = modeofPayment;
    }

    public PayPal makePayment(double amount) {
        // PayPal-specific payment processing logic
        System.out.println("Paid $" + amount + " via PayPal.");
        PayPal payPal = new PayPal();
        try {
            transactionId++;
            payPal.setModeofPayment(ModeofPayment.ONLINE);
            payPal.setPaymentStatus(PaymentStatus.SUCCESS);
            return payPal;
        }catch(Exception e) {
        payPal.setPaymentStatus(PaymentStatus.FAILURE);
        }
      return payPal;
    }
}
