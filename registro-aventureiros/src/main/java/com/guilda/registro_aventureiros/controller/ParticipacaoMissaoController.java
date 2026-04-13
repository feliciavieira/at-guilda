package com.guilda.registro_aventureiros.controller;

import com.guilda.registro_aventureiros.service.ParticipacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/participacoes")
@RequiredArgsConstructor // Isso substitui o construtor manual que estava dando erro
public class ParticipacaoMissaoController {

    private final ParticipacaoService participacaoService;

    @GetMapping("/ranking")
    public ResponseEntity<?> verRankingParticipacao() {
        return ResponseEntity.ok(participacaoService.gerarRanking());
    }
}