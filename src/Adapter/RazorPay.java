package Adapter;

import Models.ModeofPayment;
import Models.PaymentStatus;

public class RazorPay {


    private static int transactionId;
    private PaymentStatus paymentStatus;
    private ModeofPayment modeofPayment;
    private double amount;

    public static int getTransactionId() {
        return transactionId;
    }

    public static void setTransactionId(int transactionId) {
        RazorPay.transactionId = transactionId;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public RazorPay executePayment(double amount) {

        // PayPal-specific payment processing logic
        System.out.println("Processed $" + amount + " via RazorPay.");
        RazorPay razorPay = new RazorPay();
        try {
            transactionId++;
            razorPay.setModeofPayment(ModeofPayment.ONLINE);
            razorPay.setPaymentStatus(PaymentStatus.SUCCESS);
            return razorPay;
        }catch(Exception e) {
            razorPay.setPaymentStatus(PaymentStatus.FAILURE);
        }
        return razorPay;
    }
}
