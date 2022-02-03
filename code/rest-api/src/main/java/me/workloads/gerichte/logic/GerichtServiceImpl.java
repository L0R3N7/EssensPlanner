package me.workloads.gerichte.logic;

import me.workloads.gerichte.Gericht;
import me.workloads.person.Person;
import me.workloads.person.logic.PersonRepo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class GerichtServiceImpl implements GerichtService{

    @Inject
    private GerichtRepo gerichtRepo;
    @Inject
    private PersonRepo personRepo;

    @Override
    public List<Gericht> search(String searchString) {
        return this.gerichtRepo.search(searchString);
    }

    @Override
    public boolean isFavorite(Person person, long gerichtId) {
        return this.gerichtRepo.isFavorite(person,gerichtId);
    }

    @Override
    public Gericht getGerichtById(long gerichtId) {
        return this.gerichtRepo.getGerichtById(gerichtId);
    }

    @Override
    public void update(Gericht gericht) {
        this.gerichtRepo.update(gericht);
    }

}
