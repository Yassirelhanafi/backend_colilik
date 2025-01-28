package ma.ac.emi.co_transport_de_colis.factories;

import ma.ac.emi.co_transport_de_colis.entities.RechargeStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PaymentStrategyFactory {

    private final Map<String, RechargeStrategy> strategies;

    public PaymentStrategyFactory(Map<String, RechargeStrategy> strategies) {
        this.strategies = strategies;
    }

    public RechargeStrategy getStrategy(String method) {
        RechargeStrategy strategy = strategies.get(method.toLowerCase());
        if (strategy == null) {
            throw new IllegalArgumentException("payment method is not supported : " + method);
        }
        return strategy;
    }
}
