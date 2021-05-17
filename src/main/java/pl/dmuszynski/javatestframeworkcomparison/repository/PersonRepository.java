package pl.dmuszynski.javatestframeworkcomparison.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dmuszynski.javatestframeworkcomparison.model.user.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
