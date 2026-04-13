package com.guilda.registro_aventureiros.model.operacoes;

import com.guilda.registro_aventureiros.model.enums.GrauPerigo;
import com.guilda.registro_aventureiros.model.enums.StatusMissao;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_missoes")
@Data
public class Missao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Enumerated(EnumType.STRING)
    private StatusMissao status;

    @Enumerated(EnumType.STRING)
    private GrauPerigo nivelPerigo;

    private LocalDateTime createdAt;
}