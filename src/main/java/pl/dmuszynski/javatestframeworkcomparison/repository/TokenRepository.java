package pl.dmuszynski.javatestframeworkcomparison.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dmuszynski.javatestframeworkcomparison.model.Token;

@Repository
public interface TokenRepository extends CrudRepository<Token, Long> {

}
