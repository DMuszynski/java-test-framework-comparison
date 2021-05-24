package javatestframeworkcomparison.service;

import javatestframeworkcomparison.payload.JwtResponseDTO;

public interface LoginService {
    JwtResponseDTO signIn(String username, String password);
}
