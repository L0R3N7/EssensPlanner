package me.workloads.user;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class GeplanntesId implements Serializable {
    @Id
    private Date date;
    @Id
    @Column(name = "person_id")
    private Long personId;

    public GeplanntesId() {
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GeplanntesId that = (GeplanntesId) o;
        return date != null && Objects.equals(date, that.date)
                && personId != null && Objects.equals(personId, that.personId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, personId);
    }
}
