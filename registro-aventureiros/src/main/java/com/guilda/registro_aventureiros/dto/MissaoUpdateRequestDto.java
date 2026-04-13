package com.guilda.registro_aventureiros.dto;

import com.guilda.registro_aventureiros.model.enums.GrauPerigo;
import com.guilda.registro_aventureiros.model.enums.StatusMissao;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MissaoUpdateRequestDto {
    private String titulo;
    private GrauPerigo nivelPerigo;
    private StatusMissao status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}