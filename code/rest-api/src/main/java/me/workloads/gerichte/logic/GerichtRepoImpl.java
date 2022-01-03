package me.workloads.gerichte.logic;

import me.workloads.gerichte.Gericht;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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
}
