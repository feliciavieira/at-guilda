package com.guilda.registro_aventureiros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    private String id;
    private String nome;
    private Double preco;
    private String categoria;
    private String raridade;
}