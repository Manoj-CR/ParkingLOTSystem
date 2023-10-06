package Adapter;

import Models.Payment;
import Models.PaymentStatus;

public class RazorPayAdapter implements PaymentGateway{


        private RazorPay paymentGateway;

        public RazorPayAdapter() {
            this.paymentGateway = paymentGateway;
        }

        @Override
        public Payment processPayment(double amount) {
            // Convert our application's method to PayPal's method
            Payment payment=new Payment();
            RazorPay razorPay=paymentGateway.executePayment(amount);
            if(razorPay.getPaymentStatus().equals(PaymentStatus.SUCCESS)) {
                payment.setPaymentStatus(PaymentStatus.SUCCESS);
                payment.setModeofPayment(razorPay.getModeofPayment());
                payment.setAmount(amount);
                payment.setTransactionId(RazorPay.getTransactionId());
                payment.setId(RazorPay.getTransactionId());
                return payment;
            }else{
                return null;
        }
    }
}
