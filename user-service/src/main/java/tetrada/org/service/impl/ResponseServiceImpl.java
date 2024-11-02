package tetrada.org.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tetrada.org.service.ResponseService;

import java.util.HashMap;

@Service
public class ResponseServiceImpl implements ResponseService {
    public ResponseEntity<Object> failed(String error, HttpStatus httpStatus)  {
        HashMap<String, Object> response = new HashMap<>();

        response.put("ok", false);
        response.put("error", error);

        return ResponseEntity
                .status(httpStatus)
                .body(response);
    }

    public ResponseEntity<Object> unauthorized() {
        return failed("unauthorized", HttpStatus.UNAUTHORIZED);
    }

    public ResponseEntity<Object> notFound() {
        return failed("not_found", HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> failed(String error) {
        return failed(error, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> failed() {
        return failed("bad_request");
    }

}