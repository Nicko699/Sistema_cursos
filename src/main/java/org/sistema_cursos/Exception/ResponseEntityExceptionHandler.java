package org.sistema_cursos.Exception;

import org.sistema_cursos.Exception.Dto.MensajeError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MensajeError> notFoundException(NotFoundException exception) {

        MensajeError mensajeError = new MensajeError(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException exception) {

        Map<String, String> mensajeError = new HashMap<>();

        List<FieldError> listaErrores = exception.getBindingResult().getFieldErrors();

        for (FieldError error : listaErrores) {

            String fieldName = error.getField();
            String message = error.getDefaultMessage();

            mensajeError.put(fieldName, message);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensajeError);

    }

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<MensajeError> badRequest(BadRequest exception) {

        MensajeError mensajeError = new MensajeError(HttpStatus.BAD_REQUEST, exception.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensajeError);

    }
}

