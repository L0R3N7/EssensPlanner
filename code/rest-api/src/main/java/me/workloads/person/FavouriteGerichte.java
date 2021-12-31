package me.workloads.person;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class FavouriteGerichte {
    @EmbeddedId
    FavouriteGerichteId id;

    public FavouriteGerichte() {
    }

    public FavouriteGerichteId getId() {
        return id;
    }

    public void setId(FavouriteGerichteId id) {
        this.id = id;
    }
}
