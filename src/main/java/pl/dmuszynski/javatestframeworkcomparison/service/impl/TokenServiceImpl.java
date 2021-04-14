package pl.dmuszynski.javatestframeworkcomparison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import pl.dmuszynski.javatestframeworkcomparison.model.Token;
import pl.dmuszynski.javatestframeworkcomparison.model.User;
import pl.dmuszynski.javatestframeworkcomparison.repository.TokenRepository;
import pl.dmuszynski.javatestframeworkcomparison.service.MessageService;
import pl.dmuszynski.javatestframeworkcomparison.service.TokenService;

import java.util.UUID;

@Service(value = "tokenService")
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;
    private final MessageService messageService;

    @Autowired
    public TokenServiceImpl(TokenRepository tokenRepository, MessageService messageService) {
        this.tokenRepository = tokenRepository;
        this.messageService = messageService;
    }

    @Override
    public Token findTokenByValue(String value) {
        return tokenRepository.findByValue(value)
                .orElseThrow(() -> new ResourceNotFoundException("Token not found for this value: " + value));
    }

    @Override
    public void sendTokenToUser(User user) {
        final Token userToken = this.generateNewUserToken(user);
        final String mailSubject = "Potwierdzenie rejestracji konta";
        final String mailContent = "Wymagane potwierdzenie rejestracji. Aby aktywować konto kliknij w poniższy link: \n"
                + "http://localhost:8080/app/token?value=" + userToken.getValue();

        this.messageService.sendMessage(user.getEmail(), mailSubject, mailContent, true);
    }

    private Token generateNewUserToken(User user) {
        String tokenValue;
        do tokenValue = UUID.randomUUID().toString();
        while (tokenRepository.existsTokenByValue(tokenValue));

        return tokenRepository.save(new Token(tokenValue, user));
    }
}
