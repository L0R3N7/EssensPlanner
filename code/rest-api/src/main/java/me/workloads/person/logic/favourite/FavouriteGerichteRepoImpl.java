package me.workloads.person.logic.favourite;

import me.workloads.gerichte.Gericht;
import me.workloads.person.FavouriteGerichte;
import me.workloads.person.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class FavouriteGerichteRepoImpl implements FavouriteGerichteRepo{

    @Inject
    EntityManager entityManager;

    @Override
    public void update(FavouriteGerichte favouriteGerichte) {
        this.entityManager.merge(favouriteGerichte);
    }

    @Override
    public void delete(Person person, Gericht gericht) {
        this.entityManager.createQuery("delete FavouriteGerichte fg where fg.id.gericht = :gerichte and fg.id.person = :person")
                .setParameter("person", person)
                .setParameter("gerichte", gericht)
                .executeUpdate();
    }

    @Override
    public void add(FavouriteGerichte favouriteGerichte) {
        this.entityManager.persist(favouriteGerichte);
    }
}
