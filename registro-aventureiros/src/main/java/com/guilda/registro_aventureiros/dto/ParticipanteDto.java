package com.guilda.registro_aventureiros.dto;

import lombok.Data;

@Data
public class ParticipanteDto {
    private Long aventureiroId;
    private String nomeAventureiro;
    private String papel;
    private boolean destaque;
}