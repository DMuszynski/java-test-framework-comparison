package javatestframeworkcomparison.service.impl;

import org.springframework.stereotype.Service;
import javatestframeworkcomparison.model.production.Film;
import javatestframeworkcomparison.payload.FilmDTO;
import javatestframeworkcomparison.repository.FilmRepository;
import javatestframeworkcomparison.service.FilmService;

import javax.persistence.EntityManager;
import java.util.Set;

@Service(value = "filmService")
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;
    private final EntityManager entityManager;

    public FilmServiceImpl(FilmRepository filmRepository, EntityManager entityManager) {
        this.filmRepository = filmRepository;
        this.entityManager = entityManager;
    }

    @Override
    public void createFilm(FilmDTO filmDetails) {
        this.filmRepository.save(new Film.Builder()
            .name(filmDetails.getName())
            .description(filmDetails.getDescription())
            .direction(filmDetails.getDirection())
            .scenario(filmDetails.getScenario())
            .productionPlace(filmDetails.getProductionPlace())
            .releaseDate(filmDetails.getReleaseDate())
            .build()
        );
    }

    @Override
    public void updateFilm(FilmDTO filmDetails, Long filmId) {

    }

    @Override
    public void deleteFilmById(Long filmId) {

    }

    @Override
    public Set<FilmDTO> findAllFilms() {
        return null;
    }

    @Override
    public FilmDTO findFilmById(Long filmId) {
        return null;
    }
}
