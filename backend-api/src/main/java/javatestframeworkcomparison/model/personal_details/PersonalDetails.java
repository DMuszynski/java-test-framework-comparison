package javatestframeworkcomparison.model.personal_details;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Embeddable
public class PersonalDetails {

    @NotNull
    @Column(name = "first_name", length = 20)
    private String firstName;

    @NotNull
    @Column(name = "last_name", length = 30)
    private String lastName;

    @Column(name = "birth_place", length = 40)
    private String birthPlace;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "date_of_death")
    private LocalDate dateOfDeath;

    public static final class Builder {
        private String firstName;
        private String lastName;
        private String birthPlace;
        private LocalDate dateOfBirth;
        private LocalDate dateOfDeath;

        public PersonalDetails.Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonalDetails.Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonalDetails.Builder birthPlace(String birthPlace) {
            this.birthPlace = birthPlace;
            return this;
        }

        public PersonalDetails.Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public PersonalDetails.Builder dateOfDeath(LocalDate dateOfDeath) {
            this.dateOfDeath = dateOfDeath;
            return this;
        }

        public PersonalDetails build() {
            final PersonalDetails personalDetails = new PersonalDetails();
            personalDetails.firstName = firstName;
            personalDetails.lastName = lastName;
            personalDetails.birthPlace = birthPlace;
            personalDetails.dateOfBirth = dateOfBirth;
            personalDetails.dateOfDeath = dateOfDeath;

            return personalDetails;
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
