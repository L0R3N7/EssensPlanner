package me.workloads.person.logic.favourite;

import me.workloads.gerichte.Gericht;
import me.workloads.person.FavouriteGerichte;
import me.workloads.person.Person;

public interface FavouriteGerichteService {

    void update(FavouriteGerichte favouriteGerichte);

    void delete(Person person, Gericht gericht);

    void add(FavouriteGerichte favouriteGerichte);
}
