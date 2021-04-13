package pl.dmuszynski.javatestframeworkcomparison.service;

public interface RegistrationService {
    void signUp(String email, String username, String password);
    String activateAccountByUserToken(String value);
}
