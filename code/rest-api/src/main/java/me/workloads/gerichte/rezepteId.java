package me.workloads.gerichte;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class rezepteId implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Id
    @Column(name = "gerichtId", nullable = false)
    private Long gericht_id;

    public rezepteId() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        rezepteId rezepteId = (me.workloads.gerichte.rezepteId) o;
        return id != null && Objects.equals(id, rezepteId.id)
                && gericht_id != null && Objects.equals(gericht_id, rezepteId.gericht_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gericht_id);
    }
}
