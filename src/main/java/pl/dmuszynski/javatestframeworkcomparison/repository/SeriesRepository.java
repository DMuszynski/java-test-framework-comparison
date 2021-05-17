package pl.dmuszynski.javatestframeworkcomparison.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmuszynski.javatestframeworkcomparison.model.production.Series;

@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {

}
