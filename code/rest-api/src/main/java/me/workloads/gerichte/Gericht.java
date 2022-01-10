package me.workloads.gerichte;

import me.workloads.person.FavouriteGerichte;
import me.workloads.person.Tagesplan;
import me.workloads.zutaten.Zutaten;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Gericht {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ImageUrl;
    String Name;
    @Column(length = 1200)
    String rezept;

    @OneToMany(
            mappedBy = "id.gericht",
            cascade = CascadeType.ALL
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    List<Tagesplan> tagesplanList = new ArrayList<>();

    @OneToMany(
            mappedBy = "id.gericht",
            cascade = CascadeType.ALL
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    List<FavouriteGerichte> favouriteGerichteList;



    @OneToMany(
            mappedBy = "id.gericht",
            cascade = CascadeType.ALL
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    List<Zutaten> zutatenList = new ArrayList<>();


    public Gericht() {
    }

    public List<Tagesplan> getTagesplanList() {
        return tagesplanList;
    }

    public void setTagesplanList(List<Tagesplan> tagesplanList) {
        this.tagesplanList = tagesplanList;
    }

    public List<FavouriteGerichte> getFavouriteGerichteList() {
        return favouriteGerichteList;
    }

    public void setFavouriteGerichteList(List<FavouriteGerichte> favouriteGerichteList) {
        this.favouriteGerichteList = favouriteGerichteList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRezept() {
        return rezept;
    }

    public void setRezept(String rezept) {
        this.rezept = rezept;
    }

    public List<Zutaten> getZutatenList() {
        return zutatenList;
    }

    public void setZutatenList(List<Zutaten> zutatenList) {
        this.zutatenList = zutatenList;
    }

    public void addFavouriteGerichteList(FavouriteGerichte favouriteGerichte) {
        this.favouriteGerichteList.add(favouriteGerichte);
    }
}
