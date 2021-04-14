package pl.dmuszynski.javatestframeworkcomparison.payload;

import java.io.Serializable;

public class SignUpRequestDTO implements Serializable {
    private String email;
    private String username;
    private String password;

    public SignUpRequestDTO() {}

    public SignUpRequestDTO(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
