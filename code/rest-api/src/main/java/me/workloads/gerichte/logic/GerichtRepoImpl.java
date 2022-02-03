package me.workloads.gerichte.logic;

import me.workloads.gerichte.Gericht;
import me.workloads.person.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class GerichtRepoImpl implements GerichtRepo{

    private EntityManager entityManager;

    public GerichtRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Gericht> search(String searchString) {
        TypedQuery<Gericht> gerichtTypedQuery = this.entityManager
                .createQuery("select g from Gericht g where upper(g.Name) like :searchString", Gericht.class)
                .setParameter("searchString", searchString.toUpperCase()+"%");
        return gerichtTypedQuery.getResultList();
    }

    @Override
    public boolean isFavorite(Person person, long gerichtId) {
        TypedQuery<Long> longTypedQuery = this.entityManager
                .createQuery("select count (fg)from FavouriteGerichte fg where fg.id.person.id = :personId and fg.id.gericht.id = :id", Long.class)
                .setParameter("personId", person.getId())
                .setParameter("id", gerichtId);

        long result = longTypedQuery.getResultStream().findFirst().orElse(0L);
        return result != 0;
    }

    @Override
    public Gericht getGerichtById(long gerichtId) {
        TypedQuery<Gericht> typedQuery = this.entityManager
                .createQuery("select g from Gericht g where g.id = :id", Gericht.class)
                .setParameter("id", gerichtId);
        return typedQuery.getResultStream().findFirst().orElse(null);
    }

    @Override
    public void update(Gericht gericht) {
        this.entityManager.merge(gericht);
    }


    /*@Override
    public Gericht getGerichtByIds(List<Long> ids) {
        var query = this.entityManager
                .createQuery("select g from Gericht g where g.id in :ids", Gericht.class)
                .setParameter("ids", ids);
        return query.getResultList();
    }*/

}
