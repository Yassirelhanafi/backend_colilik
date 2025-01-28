package ma.ac.emi.co_transport_de_colis.entities;

import jakarta.validation.constraints.NotNull;

public class PaymentRequest {
    @NotNull
    private Long amount;
    @NotNull
    private String currency;

    @NotNull
    private String id_user;

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

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
}
