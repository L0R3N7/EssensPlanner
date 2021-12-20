
package me.workloads.gerichte;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "zutatenliste")
public class Zutatenliste {
    @EmbeddedId
    ZutatenlisteId id;
    private Double Amount;
    private String Messart;

    @ManyToOne
    @MapsId("rezept_id")
    @JoinColumn(name = "rezeptId")
    Rezepte rezepte;

    @OneToOne
    Zutaten zutaten;

    public Zutatenliste() {
    }

    public ZutatenlisteId getId() {
        return id;
    }

    public void setId(ZutatenlisteId id) {
        this.id = id;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    public String getMessart() {
        return Messart;
    }

    public void setMessart(String messart) {
        Messart = messart;
    }


    public Zutaten getZutaten() {
        return zutaten;
    }

    public void setZutaten(Zutaten zutaten) {
        this.zutaten = zutaten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Zutatenliste that = (Zutatenliste) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}