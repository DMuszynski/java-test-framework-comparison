package pl.dmuszynski.javatestframeworkcomparison.service;

import pl.dmuszynski.javatestframeworkcomparison.payload.JwtResponseDTO;

public interface LoginService {
    JwtResponseDTO signIn(String username, String password);
}
