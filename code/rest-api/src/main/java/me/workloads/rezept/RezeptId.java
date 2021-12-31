package me.workloads.rezept;

import me.workloads.gerichte.Gericht;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class RezeptId implements Serializable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @ManyToOne
    Gericht gericht;

    public RezeptId() {
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
