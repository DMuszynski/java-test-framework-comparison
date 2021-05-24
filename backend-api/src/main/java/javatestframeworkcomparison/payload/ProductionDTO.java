package javatestframeworkcomparison.payload;

import java.time.LocalDate;

public class ProductionDTO extends AbstractDTO {
    protected String name;
    protected String description;
    protected String productionPlace;
    protected LocalDate releaseDate;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getProductionPlace() {
        return productionPlace;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
}
