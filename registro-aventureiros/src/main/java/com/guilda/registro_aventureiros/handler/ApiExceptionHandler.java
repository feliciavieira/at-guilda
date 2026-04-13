package com.guilda.registro_aventureiros.handler;

import com.guilda.registro_aventureiros.exception.ObjetoNaoEncontradoException;
import com.guilda.registro_aventureiros.exception.RegraNegocioException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> tratarObjetoNaoEncontrado(ObjetoNaoEncontradoException ex) {
        Map<String, String> erro = new HashMap<>();
        erro.put("mensagem", "Recurso não encontrado");
        erro.put("detalhe", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> tratarArgumentoInvalido(IllegalArgumentException ex) {
        Map<String, String> erro = new HashMap<>();
        erro.put("mensagem", "Requisição inválida");
        erro.put("detalhe", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<Map<String, String>> tratarErroNegocio(RegraNegocioException ex) {
        Map<String, String> erro = new HashMap<>();
        erro.put("mensagem", "Regra de negócio violada");
        erro.put("detalhe", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}