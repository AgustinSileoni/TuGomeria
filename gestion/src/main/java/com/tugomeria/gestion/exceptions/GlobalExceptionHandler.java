package com.tugomeria.gestion.exceptions;

import com.tugomeria.gestion.clientes.exceptions.ClienteNoEncontradoException;
import com.tugomeria.gestion.vehiculos.exceptions.PatenteExistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClienteNoEncontradoException.class )
    public ResponseEntity<Map<String,String>> handleClienteNoEncontradoException(ClienteNoEncontradoException ex){
        Map<String,String> errores = new HashMap<>();
        errores.put("message", ex.getMessage());
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(PatenteExistenteException.class )
    public ResponseEntity<Map<String,String>> handlePatenteExistenteException(PatenteExistenteException ex){
        Map<String,String> errores = new HashMap<>();
        errores.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errores);
    }
}
