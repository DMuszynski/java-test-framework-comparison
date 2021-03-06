package javatestframeworkcomparison.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javatestframeworkcomparison.model.production.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

}
