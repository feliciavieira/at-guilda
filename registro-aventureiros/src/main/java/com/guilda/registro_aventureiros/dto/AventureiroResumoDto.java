package com.guilda.registro_aventureiros.dto;

import com.guilda.registro_aventureiros.model.enums.Classe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AventureiroResumoDto {
    private Long id;
    private String nome;
    private Classe classe;
    private Integer nivel;
    private boolean ativo;
}