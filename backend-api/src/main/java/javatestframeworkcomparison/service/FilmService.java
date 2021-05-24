package javatestframeworkcomparison.service;

import javatestframeworkcomparison.payload.FilmDTO;

import java.util.Set;

public interface FilmService {
    void createFilm(FilmDTO filmDetails);
    void updateFilm(FilmDTO filmDetails, Long filmId);
    void deleteFilmById(Long filmId);
    Set<FilmDTO> findAllFilms();
    FilmDTO findFilmById(Long filmId);
}
