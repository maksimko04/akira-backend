package tetrada.org.exception;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tetrada.org.service.ResponseService;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private ResponseService responseService;

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<Object> handleUserExistsException(){
        return responseService.failed("user already exists");
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFound() {
        return responseService.failed("user not found");
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<Object> handleIncorrectPassword() {
        return responseService.failed("incorrect password");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException() {
        return responseService.failed("incorrect data");
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationException() {
        return responseService.failed("incorrect data");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException() {
        return responseService.failed("incorrect data");
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Object> handleThrowable(Throwable e) {
        System.err.println("[SERVER ERROR]");
        e.printStackTrace(System.err);

        return responseService.failed("server_error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}