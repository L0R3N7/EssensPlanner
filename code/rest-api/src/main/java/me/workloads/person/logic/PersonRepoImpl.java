package me.workloads.person.logic;

import me.workloads.person.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

@ApplicationScoped
public class PersonRepoImpl implements PersonRepo {

    private final EntityManager entityManager;

    public PersonRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void update(Person u) {
        entityManager.merge(u);
    }

    @Override
    public void add(Person u) {
        entityManager.persist(u);
    }
}
