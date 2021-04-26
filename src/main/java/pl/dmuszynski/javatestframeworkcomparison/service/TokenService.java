package pl.dmuszynski.javatestframeworkcomparison.service;

import pl.dmuszynski.javatestframeworkcomparison.model.user.Token;
import pl.dmuszynski.javatestframeworkcomparison.model.user.User;

public interface TokenService {
    Token findTokenByValue(String value);
    void sendTokenToUser(User user);
}
