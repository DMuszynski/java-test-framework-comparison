package pl.dmuszynski.javatestframeworkcomparison.service;

import pl.dmuszynski.javatestframeworkcomparison.model.Token;
import pl.dmuszynski.javatestframeworkcomparison.model.User;

public interface TokenService {
    Token findTokenByValue(String value);
    void sendTokenToUser(User user);
}
