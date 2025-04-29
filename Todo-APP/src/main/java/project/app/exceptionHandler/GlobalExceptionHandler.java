package project.app.exceptionHandler;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import project.app.entity.Todo;
import project.app.exception.LoginExceptionUnautorized;
import project.app.exception.UnautorizedUserException;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(exception = LoginExceptionUnautorized.class)
    public ResponseEntity<String> errorResponseStatusException(LoginExceptionUnautorized exceptionUnautorized){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exceptionUnautorized.getMessage());
    }

    @ExceptionHandler(exception = UnautorizedUserException.class)
    public ResponseEntity<String> errorUnautorizedException(UnautorizedUserException unautorizedUserException){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(unautorizedUserException.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(exception = ConstraintViolationException.class)
    public HashMap<String, String> errorCatch(ConstraintViolationException ex){
        HashMap<String, String> hashMap = new HashMap<>();
        ex.getConstraintViolations().forEach(
                values -> hashMap.put(values.getPropertyPath().toString(), values.getMessage())
        );
        return hashMap;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> errorDataNotFound(NoSuchElementException suchElement){
        return ResponseEntity.ok(suchElement.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> NullPointerException(NullPointerException e){

    }




}
