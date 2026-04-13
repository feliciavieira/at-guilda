package com.guilda.registro_aventureiros.controller;

import com.guilda.registro_aventureiros.model.operacoes.PainelTaticoMissao;
import com.guilda.registro_aventureiros.service.MissaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/missoes")
@RequiredArgsConstructor
public class MissaoController {

    private final MissaoService missaoService;

    @GetMapping("/top")
    public ResponseEntity<List<PainelTaticoMissao>> getTopMissoes() {
        return ResponseEntity.ok(missaoService.buscarTopMissoes());
    }

    @PostMapping("/{id}/concluir")
    public ResponseEntity<Void> concluir(@PathVariable Long id) {
        missaoService.concluirMissao(id);
        return ResponseEntity.noContent().build();
    }
}