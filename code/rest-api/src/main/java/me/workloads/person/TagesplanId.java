package me.workloads.person;

import me.workloads.gerichte.Gericht;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Embeddable
public class TagesplanId implements Serializable {
    Long personId;
    LocalDate localDate;

    public TagesplanId() {
    }

    public static TagesplanId create(Long personId, LocalDate dateTemp) {
        TagesplanId tagesplanId = new TagesplanId();
        tagesplanId.setLocalDate(dateTemp);
        tagesplanId.setPersonId(personId);
        return tagesplanId;
    }


    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
