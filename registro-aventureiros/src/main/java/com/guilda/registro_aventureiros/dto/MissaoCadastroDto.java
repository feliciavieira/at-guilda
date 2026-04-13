package com.guilda.registro_aventureiros.dto;

import com.guilda.registro_aventureiros.model.enums.GrauPerigo;
import com.guilda.registro_aventureiros.model.enums.StatusMissao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MissaoCadastroDto {
    @NotBlank(message = "Título é obrigatório")
    private String titulo;
    @NotNull(message = "Nível de perigo é obrigatório")
    private GrauPerigo nivelPerigo;
    @NotNull(message = "Status é obrigatório")
    private StatusMissao status;
    @NotNull(message = "ID da organização é obrigatório")
    private Long organizacaoId;
}