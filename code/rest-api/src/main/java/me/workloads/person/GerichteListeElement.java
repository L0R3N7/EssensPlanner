package me.workloads.person;

import com.sun.tools.javac.jvm.Gen;

import javax.persistence.*;

@Entity
public class GerichteListeElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long sequence;
    Long gerichtId;
    @ManyToOne
    Tagesplan tagesplan;

    public GerichteListeElement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSequence() {
        return sequence;
    }

    public void setSequence(Long sequence) {
        this.sequence = sequence;
    }

    public Tagesplan getTagesplan() {
        return tagesplan;
    }

    public void setTagesplan(Tagesplan tagesplan) {
        this.tagesplan = tagesplan;
    }

    public Long getGerichtId() {
        return gerichtId;
    }

    public void setGerichtId(Long gerichtId) {
        this.gerichtId = gerichtId;
    }

    public static GerichteListeElement create(long sequence, long gerichtId, Tagesplan tagesplan){
        GerichteListeElement gerichteListeElement = new GerichteListeElement();
        gerichteListeElement.setGerichtId(gerichtId);
        gerichteListeElement.setSequence(sequence);
        gerichteListeElement.setTagesplan(tagesplan);

        return gerichteListeElement;
    }
}
