package me.workloads.gerichte.logic;


import me.workloads.gerichte.Gericht;
import me.workloads.person.Person;

import java.util.List;

public interface GerichtService {

    List<Gericht> search(String searchString);

    boolean isFavorite(Person person, long gerichtId);
    
    Gericht getGerichtById(long gerichtId);

    void update(Gericht gericht);
}
