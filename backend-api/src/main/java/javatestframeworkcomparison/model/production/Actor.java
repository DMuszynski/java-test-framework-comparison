package javatestframeworkcomparison.model.production;

import com.sun.istack.NotNull;
import javatestframeworkcomparison.model.AbstractEntity;
import javatestframeworkcomparison.model.personal_details.PersonalDetails;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "ACTOR")
public class Actor extends AbstractEntity {

    @Embedded
    PersonalDetails personalDetails;

    @NotNull
    @Column(name = "biography", length = 500)
    private String biography;

    public Actor() {}

    public Actor(Long id, String name, String surname, String birthplace, LocalDate dateOfBirth, String description) {
        super(id);

    }
}
