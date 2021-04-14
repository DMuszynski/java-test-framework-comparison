package pl.dmuszynski.javatestframeworkcomparison.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmuszynski.javatestframeworkcomparison.exception.UniqueUsernameException;
import pl.dmuszynski.javatestframeworkcomparison.repository.UserRepository;

@Component
public class UniqueUsernameValidator {

    private final UserRepository userRepository;

    @Autowired
    public UniqueUsernameValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validate(String username) throws UniqueUsernameException {
        if (this.userRepository.existsByUsername(username))
            throw new UniqueUsernameException("Użytkownik z podanym nickiem już istnieje");
    }
}
