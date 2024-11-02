package tetrada.org.exception;

import org.springframework.web.ErrorResponse;

public class UserExistsException extends RuntimeException {
    public UserExistsException() {    }

    public UserExistsException(String message) {
        super(message);
    }
}
