package me.workloads.gerichte;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ZutatenlisteId implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Id
    @Column(name = "rezeptId", nullable = false)
    private Long rezept_id;

    public ZutatenlisteId() {
    }

    public Long getRezept_id() {

        return rezept_id;
    }

    public void setRezept_id(Long rezept_id) {
        this.rezept_id = rezept_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
