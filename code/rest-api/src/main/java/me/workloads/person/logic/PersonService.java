package me.workloads.person.logic;

import me.models.PersonDTO;
import me.workloads.person.Person;

public interface PersonService {

    Person addPerson(String email, String password);

    Person validateUser(PersonDTO personDTO);

    Person findPersonBySeasionId(String email, byte[] uniqueSessionCode);
}
