package javatestframeworkcomparison.model.production;

import com.sun.istack.NotNull;
import javatestframeworkcomparison.model.AbstractEntity;

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

    @Column(name = "production_place", length = 60)
    protected String productionPlace;

    @Column(name = "release_date")
    protected LocalDate releaseDate;

    public Production() {}

    public Production(String name, String description, String productionPlace, LocalDate releaseDate) {
        this.name = name;
        this.description = description;
        this.productionPlace = productionPlace;
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

    public String getProductionPlace() {
        return productionPlace;
    }
}
