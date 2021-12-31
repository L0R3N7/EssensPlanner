package me.workloads.person;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Tagesplan {
    @EmbeddedId
    TagesplanId id;

    public Tagesplan() {
    }

    public TagesplanId getId() {
        return id;
    }

    public void setId(TagesplanId id) {
        this.id = id;
    }
}
