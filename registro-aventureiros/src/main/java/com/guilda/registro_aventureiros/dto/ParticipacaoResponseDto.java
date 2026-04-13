package com.guilda.registro_aventureiros.dto;

import lombok.Data;

@Data
public class ParticipacaoResponseDto {
    private Long id;
    private String missaoTitulo;
    private String aventureiroNome;
    private String papel;
    private Integer recompensa;
    private boolean mvp;
}