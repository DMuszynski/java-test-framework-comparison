package pl.dmuszynski.javatestframeworkcomparison.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import pl.dmuszynski.javatestframeworkcomparison.model.user.User;

@Component
public class JwtUtils {

    @Value("${secret.jwtSecret}")
    private String jwtSecret;

    public String generateJwtToken(Authentication authentication) {
        final Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
        final User userPrincipal = (User) authentication.getPrincipal();

        return JWT.create()
                .withIssuer("auth0")
                .withSubject(userPrincipal.getUsername())
                .sign(algorithm);
    }

    public boolean validateJwtToken(String authToken) {
        final Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
        try {
            final JWTVerifier jwtVerifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build();
            jwtVerifier.verify(authToken);
            return true;
        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException("Unauthorized exception");
        }
    }

    public String getUsernameFromJwtToken(String token) {
        return JWT.decode(token).getSubject();
    }
}
