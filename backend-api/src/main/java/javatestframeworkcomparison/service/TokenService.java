package javatestframeworkcomparison.service;

import javatestframeworkcomparison.model.user.Token;
import javatestframeworkcomparison.model.user.User;

public interface TokenService {
    Token findTokenByValue(String value);
    void sendTokenToUser(User user);
}
