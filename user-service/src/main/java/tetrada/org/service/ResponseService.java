package tetrada.org.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ResponseService {
    ResponseEntity<Object> failed(String error, HttpStatus httpStatus);
    ResponseEntity<Object> unauthorized();
    ResponseEntity<Object> notFound();
    ResponseEntity<Object> failed(String error);
    ResponseEntity<Object> failed();
}