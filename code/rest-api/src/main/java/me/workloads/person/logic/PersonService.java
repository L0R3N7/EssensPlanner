package me.workloads.person.logic;

import me.models.PersonDTO;
import me.workloads.person.Person;

public interface PersonService {

    Person addPerson(String email, String password);

    Person validateUser(PersonDTO personDTO);

    Boolean validateUserBySeasionId(String email, byte[] uniqueSessionCode);

    Person getUser(String email, byte[] uniqueSessionCode);

    void update(Person person);
}
