package javatestframeworkcomparison.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javatestframeworkcomparison.payload.FilmDTO;
import javatestframeworkcomparison.service.FilmService;

import java.util.Set;

@RestController
@RequestMapping(value = "app/films")
@CrossOrigin(origins = "http://localhost:4200")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createFilm(@RequestBody FilmDTO filmDetails) {
        this.filmService.createFilm(filmDetails);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{filmId}")
    public ResponseEntity<HttpStatus> updateFilm(@RequestBody FilmDTO filmDetails, @PathVariable Long filmId) {
        this.filmService.updateFilm(filmDetails, filmId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{filmId}")
    public ResponseEntity<FilmDTO> findFilmById(@PathVariable Long filmId) {
        final FilmDTO foundFilmDTO = this.filmService.findFilmById(filmId);
        return new ResponseEntity<>(foundFilmDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Set<FilmDTO>> findAllFilmsById() {
        final Set<FilmDTO> foundAllFilmsDTO = this.filmService.findAllFilms();
        return new ResponseEntity<>(foundAllFilmsDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{filmId}")
    public ResponseEntity<HttpStatus> deleteFilmById(@PathVariable Long filmId) {
        this.filmService.deleteFilmById(filmId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
