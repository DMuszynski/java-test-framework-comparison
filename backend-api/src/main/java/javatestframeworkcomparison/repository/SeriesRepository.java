package javatestframeworkcomparison.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javatestframeworkcomparison.model.production.Series;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {

}
