package Adapter;

import Models.ModeofPayment;
import Models.Payment;
import Models.PaymentStatus;

public interface PaymentGateway {
    Payment processPayment(double amount);
}
