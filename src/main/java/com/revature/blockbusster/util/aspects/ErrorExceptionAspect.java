package com.revature.blockbusster.util.aspects;

import com.revature.blockbusster.util.exceptions.AuthenticationException;
import com.revature.blockbusster.util.exceptions.InvalidRequestException;
import com.revature.blockbusster.util.exceptions.ResourcePersistanceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorExceptionAspect {

    @ExceptionHandler({InvalidRequestException.class})
    public ResponseEntity<String> handleException(Exception e){
        String message = "Caught the invalid request with: " + e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({AuthenticationException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED) //can only use with void...need to leverage ResponseEntity<> if planning to return JSON body
    public void handleException2(Exception e){
        String message = "Caught the invalid request2 with: " + e.getMessage();
        System.out.println(message);
    }

    @ExceptionHandler(ResourcePersistanceException.class)
    public ResponseEntity<String> resourceException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> exception(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }


}
