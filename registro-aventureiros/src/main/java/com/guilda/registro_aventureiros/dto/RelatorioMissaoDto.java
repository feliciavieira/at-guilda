package com.guilda.registro_aventureiros.dto;

import com.guilda.registro_aventureiros.model.enums.GrauPerigo;
import com.guilda.registro_aventureiros.model.enums.StatusMissao;
import lombok.Data;

@Data
public class RelatorioMissaoDto {
    private Long missaoId;
    private String titulo;
    private StatusMissao status;
    private GrauPerigo nivelPerigo;
    private Long totalParticipantes;
    private Long totalRecompensas;
}