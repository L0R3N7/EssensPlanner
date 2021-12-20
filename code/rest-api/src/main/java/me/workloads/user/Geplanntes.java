package me.workloads.user;

import me.workloads.gerichte.Gerichte;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Geplanntes {
    @EmbeddedId
    private GeplanntesId id;

    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany(
            mappedBy = "",
            cascade = CascadeType.REFRESH
    )
    List<Gerichte> gerichteList = new ArrayList<>();


    public Geplanntes() {
    }

    public List<Gerichte> getGerichteList() {
        return gerichteList;
    }

    public void setGerichteList(List<Gerichte> gerichteList) {
        this.gerichteList = gerichteList;
    }

    public GeplanntesId getId() {
        return id;
    }

    public void setId(GeplanntesId id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Geplanntes that = (Geplanntes) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
