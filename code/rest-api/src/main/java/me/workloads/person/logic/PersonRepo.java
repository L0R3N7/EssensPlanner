package me.workloads.person.logic;

import me.models.PersonDTO;
import me.workloads.person.Person;

public interface PersonRepo {

    void update(Person u);

    void add(Person u);

    Person validateUser(PersonDTO personDTO);
}
