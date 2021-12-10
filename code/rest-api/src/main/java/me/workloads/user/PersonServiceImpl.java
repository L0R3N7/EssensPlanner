package me.workloads.user;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonServiceImpl implements PersonService {

    private final PersonRepo personRepo;

    public PersonServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public Person addPerson(String email, String password) {
        Person u = Person.create(email, password);
        personRepo.add(u);
        return u;
    }
}
