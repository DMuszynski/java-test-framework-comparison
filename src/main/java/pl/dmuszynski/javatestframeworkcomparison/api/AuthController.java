package pl.dmuszynski.javatestframeworkcomparison.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmuszynski.javatestframeworkcomparison.payload.SignUpRequestDTO;
import pl.dmuszynski.javatestframeworkcomparison.service.RegistrationService;

@RestController
@RequestMapping(value = "app")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final RegistrationService registrationService;

    @Autowired
    public AuthController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(value = "/sign-up")
    public ResponseEntity<HttpStatus> signUp(@RequestBody SignUpRequestDTO signUpDetails) {
        this.registrationService.signUp(signUpDetails.getEmail(), signUpDetails.getUsername(), signUpDetails.getPassword());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/token")
    public ResponseEntity<String> activateUser(@RequestParam String value) {
        final String activationMessage = this.registrationService.activateAccountByUserToken(value);
        return new ResponseEntity<>(activationMessage, HttpStatus.OK);
    }
}
