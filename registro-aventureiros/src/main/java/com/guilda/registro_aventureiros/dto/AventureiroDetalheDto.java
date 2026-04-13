package com.guilda.registro_aventureiros.dto;

import com.guilda.registro_aventureiros.model.enums.Classe;
import lombok.Data;

@Data
public class AventureiroDetalheDto {
    private Long id;
    private String nome;
    private Classe classe;
    private Integer nivel;
    private boolean ativo;
    private String nomeOrganizacao;
    private Long totalParticipacoes;
    private MissaoResumoDto ultimaMissao;
}