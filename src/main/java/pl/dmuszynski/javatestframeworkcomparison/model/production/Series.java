package pl.dmuszynski.javatestframeworkcomparison.model.production;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "SERIES")
public class Series extends Production {

    @Column(name = "creator", length = 40)
    private String creator;

    public Series() {}

    public static final class Builder {
        private Long id;
        private String name;
        private String description;
        private String creator;
        private LocalDate releaseDate;

        public Series.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Series.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Series.Builder description(String description) {
            this.description = description;
            return this;
        }

        public Series.Builder creator(String creator) {
            this.creator = creator;
            return this;
        }

        public Series.Builder releaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Series build() {
            final Series series = new Series();
            series.id = id;
            series.name = name;
            series.description = description;
            series.creator = creator;
            series.releaseDate = releaseDate;

            return series;
        }
    }

    public String getCreator() {
        return creator;
    }
}
