package me.workloads.person;

import me.workloads.gerichte.Gericht;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class TagesplanId implements Serializable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    @ManyToOne
    Gericht gericht;
    @ManyToOne
    Person person;
    Date date;

    public TagesplanId() {
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
