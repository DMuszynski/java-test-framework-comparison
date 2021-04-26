package pl.dmuszynski.javatestframeworkcomparison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.dmuszynski.javatestframeworkcomparison.model.User;
import pl.dmuszynski.javatestframeworkcomparison.payload.JwtResponseDTO;
import pl.dmuszynski.javatestframeworkcomparison.security.JwtUtils;
import pl.dmuszynski.javatestframeworkcomparison.service.LoginService;

import java.util.Set;
import java.util.stream.Collectors;

@Service(value = "loginService")
public class LoginServiceImpl implements LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Autowired
    public LoginServiceImpl(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public JwtResponseDTO signIn(String username, String password) {
        final Authentication authentication = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final User userPrincipal = (User) authentication.getPrincipal();
        final Set<String> authorities = userPrincipal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        return new JwtResponseDTO.Builder()
                .id(userPrincipal.getId())
                .email(userPrincipal.getEmail())
                .username(userPrincipal.getUsername())
                .accessToken(this.jwtUtils.generateJwtToken(authentication))
                .authorities(authorities)
                .build();
    }
}
