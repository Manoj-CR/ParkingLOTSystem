package Adapter;

import Models.Payment;
import Models.PaymentStatus;

public class PaypalAdapter implements PaymentGateway{


        private PayPal paymentGateway;

        public PaypalAdapter() {
            this.paymentGateway = paymentGateway;
        }

        @Override
        public Payment processPayment(double amount) {
            // Convert our application's method to PayPal's method
            Payment payment=new Payment();
            PayPal payPal=paymentGateway.makePayment(amount);
            if(payPal.getPaymentStatus().equals(PaymentStatus.SUCCESS)) {
                payment.setPaymentStatus(PaymentStatus.SUCCESS);
                payment.setModeofPayment(payPal.getModeofPayment());
                payment.setAmount(amount);
                payment.setTransactionId(payPal.getTransactionID());
                payment.setId(payPal.getTransactionID());
                return payment;
            }else{
                return null;
        }
    }
}
