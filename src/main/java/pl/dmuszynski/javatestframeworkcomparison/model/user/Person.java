package pl.dmuszynski.javatestframeworkcomparison.model.user;

import pl.dmuszynski.javatestframeworkcomparison.model.AbstractEntity;
import pl.dmuszynski.javatestframeworkcomparison.model.personal_details.PersonalDetails;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person extends AbstractEntity {

    @Embedded
    private PersonalDetails personalDetails;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public Person() { super(); }

    public Person(User user, PersonalDetails personalDetails) {
        this();
        this.user = user;
        this.personalDetails = personalDetails;
    }

    public Person(Long id, User user, PersonalDetails personalDetails) {
        this(user, personalDetails);
        this.id = id;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public User getUser() {
        return user;
    }
}
