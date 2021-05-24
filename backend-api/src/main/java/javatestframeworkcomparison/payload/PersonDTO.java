package javatestframeworkcomparison.payload;

import java.time.LocalDate;

public class PersonDTO extends AbstractDTO {
    private String firstName;
    private String lastName;
    private String birthPlace;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;

    public static final class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String birthPlace;
        private LocalDate dateOfBirth;
        private LocalDate dateOfDeath;

        public PersonDTO.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public PersonDTO.Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonDTO.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonDTO.Builder birthPlace(String birthPlace) {
            this.birthPlace = birthPlace;
            return this;
        }

        public PersonDTO.Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public PersonDTO.Builder dateOfDeath(LocalDate dateOfDeath) {
            this.dateOfDeath = dateOfDeath;
            return this;
        }

        public PersonDTO build() {
            final PersonDTO personDTO = new PersonDTO();
            personDTO.id = id;
            personDTO.firstName = firstName;
            personDTO.lastName = lastName;
            personDTO.birthPlace = birthPlace;
            personDTO.dateOfBirth = dateOfBirth;
            personDTO.dateOfDeath = dateOfDeath;

            return personDTO;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }
}
