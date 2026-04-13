package com.guilda.registro_aventureiros.dto;

import com.guilda.registro_aventureiros.model.enums.StatusMissao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissaoListagemDto {
    private Long id;
    private String titulo;
    private StatusMissao status;
    private LocalDateTime dataCriacao;
}