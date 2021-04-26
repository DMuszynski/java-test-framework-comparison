package pl.dmuszynski.javatestframeworkcomparison.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dmuszynski.javatestframeworkcomparison.model.user.Authority;
import pl.dmuszynski.javatestframeworkcomparison.model.user.AuthorityType;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Long> {
    Optional<Authority> findByAuthorityType(AuthorityType authorityType);
}
