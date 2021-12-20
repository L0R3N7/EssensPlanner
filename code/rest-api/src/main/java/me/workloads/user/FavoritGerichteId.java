package me.workloads.user;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;



@Embeddable
public class FavoritGerichteId implements Serializable {
    @Id
    @Column(name = "personId", nullable = false)
    private Long person_id;
    @Id
    @Column(name = "gerichtId", nullable = false)
    private Long gericht_id;

    public FavoritGerichteId() {
    }

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public Long getGericht_id() {
        return gericht_id;
    }

    public void setGericht_id(Long gericht_id) {
        this.gericht_id = gericht_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FavoritGerichteId that = (FavoritGerichteId) o;
        return person_id != null && Objects.equals(person_id, that.person_id)
                && gericht_id != null && Objects.equals(gericht_id, that.gericht_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_id, gericht_id);
    }
}
