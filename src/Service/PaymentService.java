package Service;

import Adapter.PaymentGateway;
import Adapter.PaypalAdapter;
import Adapter.RazorPayAdapter;
import Models.Payment;

public class PaymentService {
    public Payment getDetails(double amount, int option) {
        PaymentGateway paymentGateway;
        if(option==1) {
             paymentGateway = new PaypalAdapter();
        }else{
             paymentGateway=new RazorPayAdapter();
        }
       return paymentGateway.processPayment(amount);
    }
}
