package com.guilda.registro_aventureiros.model.audit;

import com.guilda.registro_aventureiros.model.enums.SituacaoUsuario;
import com.guilda.registro_aventureiros.model.aventura.Organizacao;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "USUARIOS", schema = "audit") // Schema
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String username;

    @Column(name = "senha_hash", nullable = false) // Nome banco legado
    private String senha;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private SituacaoUsuario status;

    @ManyToOne
    @JoinColumn(name = "organizacao_id") // Relacionamento FK
    private Organizacao organizacao;
}