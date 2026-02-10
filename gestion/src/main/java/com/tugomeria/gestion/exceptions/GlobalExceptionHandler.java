package com.tugomeria.gestion.exceptions;

import com.tugomeria.gestion.clientes.exceptions.ClienteNoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClienteNoEncontradoException.class )
    public ResponseEntity<Map<String,String>> handleClienteNoEncontradoException(ClienteNoEncontradoException ex){
        Map<String,String> errores = new HashMap<>();
        errores.put("message", ex.getMessage());
        return ResponseEntity.badRequest().body(errores);
    }
}
