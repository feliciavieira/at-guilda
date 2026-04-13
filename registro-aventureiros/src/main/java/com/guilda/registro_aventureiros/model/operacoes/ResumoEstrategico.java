package com.guilda.registro_aventureiros.model.operacoes;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "vw_painel_tatico_missao")
public class ResumoEstrategico {
    @Id
    @Column(name = "missao_id")
    private Long id;

    private String titulo;
    private String status;

    @Column(name = "nivel_perigo")
    private String nivelPerigo;

    @Column(name = "total_participantes")
    private Integer totalParticipantes;

    @Column(name = "nivel_medio_equipe")
    private Double nivelMedioEquipe;

    @Column(name = "total_recompensa")
    private Double totalRecompensa;

    @Column(name = "ultima_atualizacao")
    private LocalDateTime ultimaAtualizacao;

    @Column(name = "indice_prontidao")
    private Double indiceProntidao;
}