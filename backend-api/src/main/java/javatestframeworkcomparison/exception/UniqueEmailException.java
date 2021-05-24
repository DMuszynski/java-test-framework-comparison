package javatestframeworkcomparison.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class UniqueEmailException extends RuntimeException {

    private static final long serialVersionUID = 7992904489502842099L;

    public UniqueEmailException(String message) {
        this(message, null);
    }

    public UniqueEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
