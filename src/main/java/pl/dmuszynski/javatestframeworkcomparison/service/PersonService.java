package pl.dmuszynski.javatestframeworkcomparison.service;

import pl.dmuszynski.javatestframeworkcomparison.payload.PersonDTO;

public interface PersonService {
    void createUserPerson(PersonDTO userPersonDetails, Long userId);
    void updateUserPerson(PersonDTO userPersonDetails, Long userId, Long personId);
    void deleteUserPersonById(Long userId , Long personId);
    PersonDTO findUserPersonById(Long userId, Long personId);
}
