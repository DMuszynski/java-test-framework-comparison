package pl.dmuszynski.javatestframeworkcomparison.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmuszynski.javatestframeworkcomparison.payload.PersonDTO;
import pl.dmuszynski.javatestframeworkcomparison.service.PersonService;

@RestController
@RequestMapping(value = "app/users/{userId}/persons")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createUserPerson(@RequestBody PersonDTO userPersonDetails, @PathVariable Long userId) {
        this.personService.createUserPerson(userPersonDetails, userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{personId}")
    public ResponseEntity<HttpStatus> updateUserPerson(@RequestBody PersonDTO userPersonDetails, @PathVariable Long userId,
                                 @PathVariable Long personId) {
        this.personService.updateUserPerson(userPersonDetails, userId, personId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{personId}")
    public ResponseEntity<PersonDTO> findUserPersonById(@PathVariable Long userId, @PathVariable Long personId) {
        final PersonDTO foundPersonDTO = this.personService.findUserPersonById(userId, personId);
        return new ResponseEntity<>(foundPersonDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{personId}")
    public ResponseEntity<HttpStatus> deleteUserPersonById(@PathVariable Long userId , @PathVariable Long personId) {
        this.personService.deleteUserPersonById(userId, personId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
