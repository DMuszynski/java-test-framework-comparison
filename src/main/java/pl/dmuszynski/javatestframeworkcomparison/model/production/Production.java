package pl.dmuszynski.javatestframeworkcomparison.model.production;

import com.sun.istack.NotNull;
import pl.dmuszynski.javatestframeworkcomparison.model.AbstractEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PRODUCTION")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Production extends AbstractEntity {

    @NotNull
    @Column(name = "name", length = 50)
    protected String name;

    @Column(name = "description", length = 500)
    protected String description;

    @Column(name = "release_date")
    protected LocalDate releaseDate;

    public Production() {}

    public Production(String name, String description, LocalDate releaseDate) {
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
}
