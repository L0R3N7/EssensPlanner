package me.workloads.zutaten;

import me.workloads.lebensmittel.Lebensmittel;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Zutaten {
    @EmbeddedId
    ZutatenId id;
    Double amount;
    String messart;
    @OneToOne
    Lebensmittel lebensmittel;

    public Zutaten() {
    }

    public ZutatenId getId() {
        return id;
    }

    public void setId(ZutatenId id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMessart() {
        return messart;
    }

    public void setMessart(String messart) {
        this.messart = messart;
    }
}
