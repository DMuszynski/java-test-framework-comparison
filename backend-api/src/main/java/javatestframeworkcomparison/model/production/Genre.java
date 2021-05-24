package javatestframeworkcomparison.model.production;

import com.sun.istack.NotNull;
import javatestframeworkcomparison.model.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "GENRE")
public class Genre extends AbstractEntity {
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "genre_type", unique = true, length = 15)
    private ProductionGenreType genreType;

    public Genre() {}

    public Genre(ProductionGenreType genreType) {
        super();
        this.genreType = genreType;
    }

    public ProductionGenreType getGenreType() {
        return genreType;
    }
}
