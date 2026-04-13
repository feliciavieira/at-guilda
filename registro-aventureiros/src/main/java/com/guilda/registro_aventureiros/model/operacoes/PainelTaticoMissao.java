package com.guilda.registro_aventureiros.model.operacoes;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vw_painel_tatico")
public class PainelTaticoMissao {
    @Id
    private Long missaoId;
    private String titulo;
    private String status;
    private Double indiceProntidao;
    private LocalDateTime ultimaAtualizacao;
}