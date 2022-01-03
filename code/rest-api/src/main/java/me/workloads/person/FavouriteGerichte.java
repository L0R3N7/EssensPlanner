package me.workloads.person;

import me.workloads.gerichte.Gericht;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class FavouriteGerichte {
    @EmbeddedId
    FavouriteGerichteId id;

    public FavouriteGerichte() {
    }

    public static FavouriteGerichte create(Person person, Gericht gericht) {
        FavouriteGerichte favouriteGerichte = new FavouriteGerichte();

        FavouriteGerichteId favouriteGerichteId = FavouriteGerichteId.create(person, gericht);
        favouriteGerichte.setId(favouriteGerichteId);
        person.addFavouriteGerichteList(favouriteGerichte);
        gericht.addFavouriteGerichteList(favouriteGerichte);

        return favouriteGerichte;
    }

    public FavouriteGerichteId getId() {
        return id;
    }

    public void setId(FavouriteGerichteId id) {
        this.id = id;
    }
}
