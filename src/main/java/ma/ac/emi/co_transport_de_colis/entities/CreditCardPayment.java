package ma.ac.emi.co_transport_de_colis.entities;

import org.springframework.stereotype.Component;

@Component("creditCard")
public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void executePayment(double amount) {

    }
}
