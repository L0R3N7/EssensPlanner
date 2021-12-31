package me.workloads.zutaten;

import me.workloads.gerichte.Gericht;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ZutatenId implements Serializable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @ManyToOne
    Gericht gericht;

    public ZutatenId() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Gericht getGericht() {
        return gericht;
    }

    public void setGericht(Gericht gericht) {
        this.gericht = gericht;
    }
}
