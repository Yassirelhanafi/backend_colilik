package ma.ac.emi.co_transport_de_colis.entities;

import java.time.LocalDateTime;

public class StripeRecharge implements RechargeStrategy {

    private Long amount;
    private LocalDateTime daterecharge;
    private String currency;
    @Override
    public void executePayment(double amount) {

    }

    public StripeRecharge(Long amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public StripeRecharge(Long amount, LocalDateTime daterecharge, String currency) {
        this.amount = amount;
        this.daterecharge = daterecharge;
        this.currency = currency;
    }

    public StripeRecharge() {
    }

    public LocalDateTime getDaterecharge() {
        return daterecharge;
    }

    public void setDaterecharge(LocalDateTime daterecharge) {
        this.daterecharge = daterecharge;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
