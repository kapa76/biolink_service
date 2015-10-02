package org.biolink.kernel;


import org.biolink.persistence.model.Person;

public interface BiolinkService {
    long createPerson(Person person);

    Person findPersonByBilink();
}
