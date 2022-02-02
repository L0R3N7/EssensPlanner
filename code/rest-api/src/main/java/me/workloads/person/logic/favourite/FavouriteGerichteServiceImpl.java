package me.workloads.person.logic.favourite;

import me.workloads.gerichte.Gericht;
import me.workloads.person.FavouriteGerichte;
import me.workloads.person.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FavouriteGerichteServiceImpl implements FavouriteGerichteService{
    @Inject
    FavouriteGerichteRepo favouriteGerichteRepo;

    @Override
    public void update(FavouriteGerichte favouriteGerichte) {
        this.favouriteGerichteRepo.update(favouriteGerichte);
    }

    @Override
    public void delete(Person person, Gericht gericht) {
        this.favouriteGerichteRepo.delete(person, gericht);
    }

    @Override
    public void add(FavouriteGerichte favouriteGerichte) {
        this.favouriteGerichteRepo.add(favouriteGerichte);
    }
}
