package com.guilda.registro_aventureiros.dto;

import com.guilda.registro_aventureiros.model.enums.Classe;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AventureiroCadastroRequestDto {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotNull(message = "Classe é obrigatória")
    private Classe classe;
    @Min(1)
    private Integer nivel = 1;
    @NotNull(message = "ID da organização é obrigatório")
    private Long organizacaoId;
}