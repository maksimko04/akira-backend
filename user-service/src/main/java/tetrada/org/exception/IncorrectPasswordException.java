package tetrada.org.exception;

public class IncorrectPasswordException extends RuntimeException{
    public IncorrectPasswordException() {    }

    public IncorrectPasswordException(String message) {
        super(message);
    }
}