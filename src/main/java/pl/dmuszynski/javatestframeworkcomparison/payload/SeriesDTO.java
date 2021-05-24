package pl.dmuszynski.javatestframeworkcomparison.payload;

import java.time.LocalDate;

public class SeriesDTO extends ProductionDTO {
    private String creator;

    public static final class Builder {
        private Long id;
        private String name;
        private String description;
        private String creator;
        private String productionPlace;
        private LocalDate releaseDate;

        public SeriesDTO.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public SeriesDTO.Builder name(String name) {
            this.name = name;
            return this;
        }

        public SeriesDTO.Builder description(String description) {
            this.description = description;
            return this;
        }

        public SeriesDTO.Builder creator(String creator) {
            this.creator = creator;
            return this;
        }

        public SeriesDTO.Builder releaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public SeriesDTO build() {
            final SeriesDTO seriesDTO = new SeriesDTO();
            seriesDTO.id = id;
            seriesDTO.name = name;
            seriesDTO.description = description;
            seriesDTO.creator = creator;
            seriesDTO.releaseDate = releaseDate;

            return seriesDTO;
        }
    }

    public String getCreator() {
        return creator;
    }
}
