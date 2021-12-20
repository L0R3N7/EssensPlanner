package me.workloads.gerichte;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "rezepte")
public class Rezepte {
    @EmbeddedId
    private rezepteId id;
    private String desc;

    @ManyToOne
    @MapsId("gericht_id")
    @JoinColumn(name = "gerichtId")
    Gerichte gerichte;

    @OneToMany(
            mappedBy = "rezepte",
            cascade = CascadeType.ALL
    )
    List<Zutatenliste> zutatenlisteArrayList = new ArrayList<>();

    public Rezepte() {
    }

    public rezepteId getId() {
        return id;
    }

    public void setId(rezepteId id) {
        this.id = id;
    }

    public List<Zutatenliste> getZutatenlisteArrayList() {
        return zutatenlisteArrayList;
    }

    public void setZutatenlisteArrayList(List<Zutatenliste> zutatenlisteArrayList) {
        this.zutatenlisteArrayList = zutatenlisteArrayList;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
        Rezepte rezepte = (Rezepte) o;
        return id != null && Objects.equals(id, rezepte.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}