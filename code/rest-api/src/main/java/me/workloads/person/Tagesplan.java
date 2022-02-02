package me.workloads.person;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tagesplan {
    @EmbeddedId
    TagesplanId id;
    @OneToMany
            (mappedBy = "tagesplan",
            cascade = CascadeType.ALL)
            @OnDelete(action = OnDeleteAction.CASCADE)
    List<GerichteListeElement> gerichteListe = new ArrayList<>();

    public Tagesplan() {
    }

    public static Tagesplan create(Long personId, LocalDate dateTemp) {
        Tagesplan tagesplan = new Tagesplan();
        tagesplan.setId(TagesplanId.create(personId, dateTemp));
        return tagesplan;
    }

    public TagesplanId getId() {
        return id;
    }

    public void setId(TagesplanId id) {
        this.id = id;
    }

    public List<GerichteListeElement> getGerichteListe() {
        return gerichteListe;
    }

    public void setGerichteListe(List<GerichteListeElement> gerichteListe) {
        this.gerichteListe = gerichteListe;
    }

    public GerichteListeElement addGerichteListe(long gerichtId){
        long maxsequence = this.gerichteListe.stream().mapToLong(GerichteListeElement::getSequence).max().orElse(0) +1;
        GerichteListeElement gerichteListeElement = GerichteListeElement.create(gerichtId, maxsequence, this);
        this.gerichteListe.add(gerichteListeElement);
        return gerichteListeElement;
    }


}
