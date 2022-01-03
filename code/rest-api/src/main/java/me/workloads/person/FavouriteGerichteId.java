package me.workloads.person;

import me.workloads.gerichte.Gericht;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class FavouriteGerichteId implements Serializable {
    @ManyToOne
    Gericht gericht;
    @ManyToOne
    Person person;

    public FavouriteGerichteId() {
    }

    public static FavouriteGerichteId create(Person person, Gericht gericht) {
        FavouriteGerichteId favouriteGerichteId = new FavouriteGerichteId();
        favouriteGerichteId.setGericht(gericht);
        favouriteGerichteId.setPerson(person);
        return favouriteGerichteId;
    }

    public Gericht getGericht() {
        return gericht;
    }

    public void setGericht(Gericht gericht) {
        this.gericht = gericht;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
