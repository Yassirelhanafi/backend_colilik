package ma.ac.emi.co_transport_de_colis.entities;

import org.springframework.stereotype.Component;

@Component("paypal")
public class PaypalRecharge implements RechargeStrategy {
    @Override
    public void executePayment(double amount) {

    }
}
