package com.guilda.registro_aventureiros.model.aventura;

import com.guilda.registro_aventureiros.model.enums.Classe;
import com.guilda.registro_aventureiros.model.audit.Usuario;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "AVENTUREIROS", schema = "aventura") // Schema
@Data
public class Aventureiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120) // para campos críticos
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Classe classe;

    @Column(nullable = false)
    private Integer nivel = 1; // novos aventureiros entrem no sistema

    @Column(nullable = false)
    private boolean ativo = true;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false) // Registro automático
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "updated_at") // Atualização automática
    private LocalDateTime dataAtualizacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "organizacao_id") // unica guilda
    private Organizacao organizacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_cadastro_id") // rastreabilidade de autoria
    private Usuario usuarioResponsavel;
}