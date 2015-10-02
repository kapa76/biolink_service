package org.biolink.kernel.impl;


import org.biolink.kernel.KernelBiolink;
import org.biolink.kernel.BiolinkService;
import org.biolink.persistence.model.Person;
import org.biolink.persistence.repository.PersonRepository;
import org.biolink.persistence.repository.TemplateImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BiolinkImpl implements BiolinkService {

    @Autowired
    private TemplateImageRepository templateImageRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private KernelBiolink biolinkKernelBiolink;

    @Override
    public long createPerson(Person person) {
        return personRepository.create(person);
    }

    @Override
    public Person findPersonByBilink() {

        biolinkKernelBiolink.Scan();



        return null;
    }
}
