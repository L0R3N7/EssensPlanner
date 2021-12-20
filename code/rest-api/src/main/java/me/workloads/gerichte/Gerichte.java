package me.workloads.gerichte;

//import me.workloads.user.FavoritGerichte;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "gerichte")
public class Gerichte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String bildUrl;
    private String name;

    /*@OneToMany(
            mappedBy = "gerichte",
            cascade = CascadeType.ALL
    )
    ArrayList<FavoritGerichte> favoritGerichteArrayList = new ArrayList<>();*/

    @OneToMany(
            mappedBy = "gerichte",
            cascade = CascadeType.ALL
    )
    List<Rezepte> rezepteArrayList = new ArrayList<>();


    public Gerichte() {
    }

    public List<Rezepte> getRezepteArrayList() {
        return rezepteArrayList;
    }

    public void setRezepteArrayList(List<Rezepte> rezepteArrayList) {
        this.rezepteArrayList = rezepteArrayList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBildUrl() {
        return bildUrl;
    }

    public void setBildUrl(String bildUrl) {
        this.bildUrl = bildUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}