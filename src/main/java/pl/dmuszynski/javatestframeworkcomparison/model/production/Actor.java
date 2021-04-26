package pl.dmuszynski.javatestframeworkcomparison.model.production;

import com.sun.istack.NotNull;
import pl.dmuszynski.javatestframeworkcomparison.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "ACTOR", schema = "SYS")
public class Actor extends AbstractEntity {

    @NotNull
    @Column(name = "name", length = 20)
    private String name;

    @NotNull
    @Column(name = "surname", length = 30)
    private String surname;

    @NotNull
    @Column(name = "birthplace", length = 40)
    private String birthplace;

    @NotNull
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @NotNull
    @Column(name = "description", length = 100)
    private String description;

    public Actor() {}

    public Actor(Long id, String name, String surname, String birthplace, LocalDate dateOfBirth, String description) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.birthplace = birthplace;
        this.dateOfBirth = dateOfBirth;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
