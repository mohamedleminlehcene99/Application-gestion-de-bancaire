package com.lehcene.app_bancaire.handlers;

import com.lehcene.app_bancaire.exceptions.EmailAlreadyExistsException;
import com.lehcene.app_bancaire.exceptions.ObjectValidationException;
import com.lehcene.app_bancaire.exceptions.OperationNonPermittedException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectValidationException.class)
    public ResponseEntity<ExceptionRepresentation> handleException(ObjectValidationException exception){
            ExceptionRepresentation representation = ExceptionRepresentation.builder()
                    .errorMessage("Object not valid")
                    .errorSource(exception.getViolationSource())
                    .validationErrors(exception.getViolations())
                    .build();

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(representation);
    }

    @ExceptionHandler(OperationNonPermittedException.class)
    public ResponseEntity<ExceptionRepresentation> handleException(OperationNonPermittedException exception){
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage(exception.getErrorMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(representation);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionRepresentation> handleException(EntityNotFoundException exception){
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage(exception.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(representation);
    }

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<ExceptionRepresentation> handleDisabledException(){
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage("Vous pouvez pas acceder à votre compte car votre compte n'est pas encore activé")
                .build();

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(representation);
    }

   /*
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionRepresentation> handleException(){
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage("This email already exist.")
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(representation);
    }
    */

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionRepresentation> hanldeBadCredentialsException(){
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage("Username or / and Password not correct.")
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(representation);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ExceptionRepresentation> handleEmailAlreadyExists(EmailAlreadyExistsException ex) {
        ExceptionRepresentation representation = ExceptionRepresentation.builder()
                .errorMessage(ex.getErrorMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(representation);
    }

}
