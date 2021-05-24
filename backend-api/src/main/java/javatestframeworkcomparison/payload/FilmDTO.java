package javatestframeworkcomparison.payload;

import java.time.LocalDate;

public class FilmDTO extends ProductionDTO {
    private String direction;
    private String scenario;

    public static final class Builder {
        private Long id;
        private String name;
        private String description;
        private String direction;
        private String scenario;
        private String productionPlace;
        private LocalDate releaseDate;

        public FilmDTO.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public FilmDTO.Builder name(String name) {
            this.name = name;
            return this;
        }

        public FilmDTO.Builder description(String description) {
            this.description = description;
            return this;
        }

        public FilmDTO.Builder direction(String direction) {
            this.direction = direction;
            return this;
        }

        public FilmDTO.Builder scenario(String scenario) {
            this.scenario = scenario;
            return this;
        }

        public FilmDTO.Builder productionPlace(String productionPlace) {
            this.productionPlace = productionPlace;
            return this;
        }

        public FilmDTO.Builder releaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public FilmDTO build() {
            final FilmDTO filmDTO = new FilmDTO();
            filmDTO.id = id;
            filmDTO.name = name;
            filmDTO.description = description;
            filmDTO.direction = direction;
            filmDTO.scenario = scenario;
            filmDTO.productionPlace = productionPlace;
            filmDTO.releaseDate = releaseDate;

            return filmDTO;
        }
    }

    public String getDirection() {
        return direction;
    }

    public String getScenario() {
        return scenario;
    }
}
