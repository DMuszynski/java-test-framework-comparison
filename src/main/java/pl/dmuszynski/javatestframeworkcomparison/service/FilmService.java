package pl.dmuszynski.javatestframeworkcomparison.service;

import pl.dmuszynski.javatestframeworkcomparison.payload.PersonDTO;

import java.util.Set;

public interface FilmService {
    void createFilm(PersonDTO userPersonDetails, Long userId);
    void updateFilm(PersonDTO userPersonDetails, Long userId, Long personId);
    void deleteFilmById(Long userId , Long personId);
    Set<PersonDTO> findAllFilms();
}
