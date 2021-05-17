package pl.dmuszynski.javatestframeworkcomparison.model.production;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "FILM")
public class Film extends Production {

    @Column(name = "direction", length = 30)
    private String direction;

    @Column(name = "scenario", length = 30)
    private String scenario;

    public Film() {}

    public static final class Builder {
        private Long id;
        private String name;
        private String description;
        private String direction;
        private String scenario;
        private LocalDate releaseDate;

        public Film.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Film.Builder name(String name) {
            this.name = name;
            return this;
        }

        public Film.Builder description(String description) {
            this.description = description;
            return this;
        }

        public Film.Builder direction(String direction) {
            this.direction = direction;
            return this;
        }

        public Film.Builder scenario(String scenario) {
            this.scenario = scenario;
            return this;
        }

        public Film.Builder releaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Film build() {
            final Film film = new Film();
            film.id = id;
            film.name = name;
            film.description = description;
            film.direction = direction;
            film.scenario = scenario;
            film.releaseDate = releaseDate;

            return film;
        }
    }

    public String getDirection() {
        return direction;
    }

    public String getScenario() {
        return scenario;
    }
}
