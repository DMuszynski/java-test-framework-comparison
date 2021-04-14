package pl.dmuszynski.javatestframeworkcomparison.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmuszynski.javatestframeworkcomparison.exception.UniqueEmailException;
import pl.dmuszynski.javatestframeworkcomparison.repository.UserRepository;

@Component
public class UniqueEmailValidator {

    private final UserRepository userRepository;

    @Autowired
    public UniqueEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validate(String email) throws UniqueEmailException {
        if (this.userRepository.existsByEmail(email))
            throw new UniqueEmailException("Użytkownik z podanym adresem email już istnieje");
    }
}
