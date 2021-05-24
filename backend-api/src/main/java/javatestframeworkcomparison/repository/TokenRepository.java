package javatestframeworkcomparison.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javatestframeworkcomparison.model.user.Token;

import java.util.Optional;

@Repository
public interface TokenRepository extends CrudRepository<Token, Long> {
    Optional<Token> findByValue(String value);
    boolean existsTokenByValue(String value);
}
