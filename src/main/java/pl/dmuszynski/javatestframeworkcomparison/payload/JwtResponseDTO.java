package pl.dmuszynski.javatestframeworkcomparison.payload;

import java.io.Serializable;
import java.util.Set;

public class JwtResponseDTO extends AbstractDTO implements Serializable {
    private String email;
    private String username;
    private String accessToken;
    private final String type = "Bearer";
    private Set<String> authorities;

    public static final class Builder {
        private Long id;
        private String email;
        private String username;
        private String accessToken;
        private Set<String> authorities;

        public JwtResponseDTO.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public JwtResponseDTO.Builder email(String email) {
            this.email = email;
            return this;
        }

        public JwtResponseDTO.Builder username(String username) {
            this.username = username;
            return this;
        }

        public JwtResponseDTO.Builder accessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public JwtResponseDTO.Builder authorities(Set<String> authorities) {
            this.authorities = authorities;
            return this;
        }

        public JwtResponseDTO build() {
            final JwtResponseDTO jwtResponseDTO = new JwtResponseDTO();
            jwtResponseDTO.id = id;
            jwtResponseDTO.email = email;
            jwtResponseDTO.username = username;
            jwtResponseDTO.accessToken = accessToken;
            jwtResponseDTO.authorities = authorities;
            return jwtResponseDTO;
        }
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getType() {
        return type;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }
}
