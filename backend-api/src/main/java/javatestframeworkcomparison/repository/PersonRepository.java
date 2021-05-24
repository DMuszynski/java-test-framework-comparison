package javatestframeworkcomparison.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javatestframeworkcomparison.model.user.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
