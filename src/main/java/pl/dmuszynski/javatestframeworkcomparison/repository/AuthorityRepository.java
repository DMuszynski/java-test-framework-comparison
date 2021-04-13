package pl.dmuszynski.javatestframeworkcomparison.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dmuszynski.javatestframeworkcomparison.model.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long> {

}
