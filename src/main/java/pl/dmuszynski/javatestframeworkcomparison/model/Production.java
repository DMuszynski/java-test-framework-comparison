package pl.dmuszynski.javatestframeworkcomparison.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PRODUCTION", schema = "SYS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Production extends AbstractEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    @Column(name = "release_date")
    private LocalDate releaseDate;

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
