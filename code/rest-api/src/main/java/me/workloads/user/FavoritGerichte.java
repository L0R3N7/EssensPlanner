package me.workloads.user;

import me.workloads.gerichte.Gerichte;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class FavoritGerichte {
    @EmbeddedId
    FavoritGerichteId id;

    @ManyToOne
    @MapsId("person_id")
    @JoinColumn(name = "personId")
    Person person;

    @ManyToOne
    @MapsId("gericht_id")
    @JoinColumn(name = "gerichtId")
    Gerichte gerichte;

    public FavoritGerichte() {
    }

    public FavoritGerichteId getId() {
        return id;
    }

    public void setId(FavoritGerichteId id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Gerichte getGerichte() {
        return gerichte;
    }

    public void setGerichte(Gerichte gerichte) {
        this.gerichte = gerichte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FavoritGerichte that = (FavoritGerichte) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
