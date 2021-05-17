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

    public Person() {}

    public Person(User user, PersonalDetails personalDetails) {
        this.user = user;
        this.personalDetails = personalDetails;
    }
}
