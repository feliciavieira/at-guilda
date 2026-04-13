package com.guilda.registro_aventureiros.controller;

import com.guilda.registro_aventureiros.dto.AventureiroCadastroRequestDto;
import com.guilda.registro_aventureiros.dto.AventureiroResumoDto;
import com.guilda.registro_aventureiros.service.AventureiroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aventureiros")
@RequiredArgsConstructor
public class AventureiroController {

    private final AventureiroService aventureiroService;

    @PostMapping
    public ResponseEntity<AventureiroResumoDto> cadastrar(@RequestBody @Valid AventureiroCadastroRequestDto dto) {
        AventureiroResumoDto response = aventureiroService.registrarNovoAventureiro(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<AventureiroResumoDto>> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {


        Pageable paginacao = PageRequest.of(page, size);

        return ResponseEntity.ok(aventureiroService.listarPaginado(paginacao));
    }
}