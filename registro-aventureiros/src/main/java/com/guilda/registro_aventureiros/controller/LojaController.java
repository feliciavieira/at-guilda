package com.guilda.registro_aventureiros.controller;

import com.guilda.registro_aventureiros.dto.ProdutoDTO;
import com.guilda.registro_aventureiros.service.LojaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/loja")
@RequiredArgsConstructor
public class LojaController {

    private final LojaService lojaService;

    // GET: Busca itens com tolerância a erros de digitação (Elasticsearch)
    @GetMapping("/buscar")
    public List<ProdutoDTO> buscar(@RequestParam String termo) {
        return lojaService.buscarComTolerancia(termo);
    }

    // GET: Retorna estatísticas de categorias (Agregação NoSQL)
    @GetMapping("/estatisticas/categorias")
    public Map<String, Long> obterEstatisticas() {
        return lojaService.contarPorCategoria();
    }

    // GET: Média de preços dos itens mágicos
    @GetMapping("/estatisticas/preco-medio")
    public Double obterPrecoMedio() {
        return lojaService.calcularMediaPrecos();
    }
}