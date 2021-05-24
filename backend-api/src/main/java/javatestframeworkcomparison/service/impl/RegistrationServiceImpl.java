package javatestframeworkcomparison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javatestframeworkcomparison.exception.AlreadyEnabledException;
import javatestframeworkcomparison.model.user.AuthorityType;
import javatestframeworkcomparison.model.user.Token;
import javatestframeworkcomparison.model.user.User;
import javatestframeworkcomparison.repository.UserRepository;
import javatestframeworkcomparison.service.AuthorityService;
import javatestframeworkcomparison.service.RegistrationService;
import javatestframeworkcomparison.service.TokenService;
import javatestframeworkcomparison.validator.UniqueEmailValidator;
import javatestframeworkcomparison.validator.UniqueUsernameValidator;

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
