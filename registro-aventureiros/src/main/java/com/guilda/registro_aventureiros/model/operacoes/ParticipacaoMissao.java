package com.guilda.registro_aventureiros.model.operacoes;

import com.guilda.registro_aventureiros.model.aventura.Aventureiro;
import com.guilda.registro_aventureiros.model.enums.FuncaoNaMissao;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "participacoes_missao")
@Data
public class ParticipacaoMissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "missao_id")
    private Missao missao;

    @ManyToOne
    @JoinColumn(name = "aventureiro_id")
    private Aventureiro aventureiro;

    @Enumerated(EnumType.STRING)
    private FuncaoNaMissao papel;

    private Integer recompensaOuro;
    private boolean destaqueMvp;
}