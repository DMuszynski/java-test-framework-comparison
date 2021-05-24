package pl.dmuszynski.javatestframeworkcomparison.service;

import pl.dmuszynski.javatestframeworkcomparison.payload.FilmDTO;

import java.util.Set;

public interface FilmService {
    void createFilm(FilmDTO filmDetails);
    void updateFilm(FilmDTO filmDetails, Long filmId);
    void deleteFilmById(Long filmId);
    Set<FilmDTO> findAllFilms();
    FilmDTO findFilmById(Long filmId);
}
