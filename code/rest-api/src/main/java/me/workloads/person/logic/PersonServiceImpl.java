package me.workloads.person.logic;

import me.models.PersonDTO;
import me.models.mapper.Mappings;
import me.workloads.person.Person;

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
        u.generateSessionCode();
        personRepo.add(u);
        return u;
    }

    @Override
    public Person validateUser(PersonDTO personDTO) {
        return this.personRepo.validateUser(personDTO);
    }

    @Override
    public Boolean validateUserBySeasionId(String email, byte[] uniqueSessionCode) {
        return this.personRepo.getUser(email, uniqueSessionCode) != null;
    }

    @Override
    public Person getUser(String email, byte[] uniqueSessionCode) {
        return this.personRepo.getUser(email, uniqueSessionCode);
    }

    @Override
    public void update(Person person) {
        this.personRepo.update(person);
    }
}
