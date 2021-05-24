package javatestframeworkcomparison.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javatestframeworkcomparison.model.production.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
}
