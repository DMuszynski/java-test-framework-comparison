package pl.dmuszynski.javatestframeworkcomparison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.dmuszynski.javatestframeworkcomparison.exception.AlreadyEnabledException;
import pl.dmuszynski.javatestframeworkcomparison.model.user.AuthorityType;
import pl.dmuszynski.javatestframeworkcomparison.model.user.Token;
import pl.dmuszynski.javatestframeworkcomparison.model.user.User;
import pl.dmuszynski.javatestframeworkcomparison.repository.UserRepository;
import pl.dmuszynski.javatestframeworkcomparison.service.AuthorityService;
import pl.dmuszynski.javatestframeworkcomparison.service.RegistrationService;
import pl.dmuszynski.javatestframeworkcomparison.service.TokenService;
import pl.dmuszynski.javatestframeworkcomparison.validator.UniqueEmailValidator;
import pl.dmuszynski.javatestframeworkcomparison.validator.UniqueUsernameValidator;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final AuthorityService authorityService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final TokenService tokenService;

    @Autowired
    public RegistrationServiceImpl(AuthorityService authorityService, PasswordEncoder passwordEncoder,
                                   UserRepository userRepository, TokenService tokenService ) {
        this.authorityService = authorityService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    @Override
    public void signUp(String email, String username, String password) {
        new UniqueUsernameValidator(userRepository).validate(username);
        new UniqueEmailValidator(userRepository).validate(email);

        final User registerUser = this.userRepository
            .save(new User.Builder()
                .email(email)
                .username(username)
                .password(passwordEncoder.encode(password))
                .authorities(Collections.singleton(this.authorityService
                        .findAuthorityByAuthorityType(AuthorityType.ROLE_USER)))
                .isEnabled(false)
                .isLocked(false)
                .build()
            );

        this.tokenService.sendTokenToUser(registerUser);
    }

    @Override
    @Transactional
    public String activateAccountByUserToken(String tokenValue) {
        final Token foundToken = this.tokenService.findTokenByValue(tokenValue);
        final User tokenUser = foundToken.getUser();

        final String activationCorrectMessage = "<h3>Rejestracja przebiegła pomyślnie!</h3>";
        final String backToServiceLink = "<a href='http://localhost:4200'>Przejdź do serwisu</a>";

        if (!tokenUser.isEnabled())
            this.userRepository.activateAccount(tokenUser.getId());
        else
            throw new AlreadyEnabledException();

        return activationCorrectMessage + backToServiceLink;
    }
}
