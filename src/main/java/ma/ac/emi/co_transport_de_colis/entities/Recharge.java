package ma.ac.emi.co_transport_de_colis.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("recharge")
public class Recharge {
    @Id
    private String id;
    private String id_user;
    private Long amount;
    private LocalDateTime date;
    public Recharge() {
    }


    public Recharge(String id, Long amount, LocalDateTime date) {
        this.id = id;
        this.amount = amount;
        this.date = date;
    }

    public Recharge(String id, String id_user, Long amount, LocalDateTime date) {
        this.id = id;
        this.id_user = id_user;
        this.amount = amount;
        this.date = date;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Recharge(Long amount, LocalDateTime date) {
        this.amount = amount;
        this.date = date;
    }
}
