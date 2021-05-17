package pl.dmuszynski.javatestframeworkcomparison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmuszynski.javatestframeworkcomparison.model.personal_details.PersonalDetails;
import pl.dmuszynski.javatestframeworkcomparison.model.user.Person;
import pl.dmuszynski.javatestframeworkcomparison.model.user.User;
import pl.dmuszynski.javatestframeworkcomparison.payload.PersonDTO;
import pl.dmuszynski.javatestframeworkcomparison.repository.PersonRepository;
import pl.dmuszynski.javatestframeworkcomparison.service.PersonService;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service(value = "personService")
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final EntityManager entityManager;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, EntityManager entityManager) {
        this.personRepository = personRepository;
        this.entityManager = entityManager;
    }

    @Override
    public void createUserPerson(PersonDTO userPersonDetails, Long userId) {
        this.personRepository
            .save(new Person(
                this.entityManager.getReference(User.class, userId),
                new PersonalDetails.Builder()
                    .firstName(userPersonDetails.getFirstName())
                    .lastName(userPersonDetails.getLastName())
                    .birthPlace(userPersonDetails.getBirthPlace())
                    .dateOfBirth(userPersonDetails.getDateOfBirth())
                    .dateOfDeath(userPersonDetails.getDateOfDeath())
                    .build()
                )
            );
    }

    @Override
    public void updateUserPerson(PersonDTO userPersonDetails, Long userId, Long personId) {
        this.personRepository
            .save(new Person(
                userPersonDetails.getId(),
                this.entityManager.getReference(User.class, userId),
                new PersonalDetails.Builder()
                    .firstName(userPersonDetails.getFirstName())
                    .lastName(userPersonDetails.getLastName())
                    .birthPlace(userPersonDetails.getBirthPlace())
                    .dateOfBirth(userPersonDetails.getDateOfBirth())
                    .dateOfDeath(userPersonDetails.getDateOfDeath())
                    .build()
                )
            );
    }

    @Override
    public PersonDTO findUserPersonById(Long userId, Long personId) {
        final Person foundPerson = this.personRepository.findById(personId)
            .orElseThrow();
        final PersonalDetails personalDetails = foundPerson.getPersonalDetails();

        return new PersonDTO.Builder()
            .id(foundPerson.getId())
            .firstName(personalDetails.getFirstName())
            .lastName(personalDetails.getLastName())
            .birthPlace(personalDetails.getBirthPlace())
            .dateOfBirth(personalDetails.getDateOfBirth())
            .dateOfDeath(personalDetails.getDateOfDeath())
            .build();
    }

    @Override
    @Transactional
    public void deleteUserPersonById(Long userId, Long personId) {
        this.entityManager.remove(this.entityManager.getReference(Person.class, personId));
    }
}
