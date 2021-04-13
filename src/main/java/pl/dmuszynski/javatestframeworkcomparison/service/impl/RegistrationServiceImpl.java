package pl.dmuszynski.javatestframeworkcomparison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmuszynski.javatestframeworkcomparison.repository.AuthorityRepository;
import pl.dmuszynski.javatestframeworkcomparison.repository.UserRepository;
import pl.dmuszynski.javatestframeworkcomparison.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    @Autowired
    public RegistrationServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void signUp(String email, String username, String password) {

    }

    @Override
    public String activateAccountByUserToken(String value) {
        return null;
    }
}
