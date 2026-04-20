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

    @Column(name = "senha_hash", nullable = false) //garantir a compatibilidade com nomes de colunas de bancos legados
    private String senha;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private SituacaoUsuario status; //salvo como texto legível, facilita audit

    @ManyToOne
    @JoinColumn(name = "organizacao_id") //estabelece uma Chave Estrangeira (FK)
    private Organizacao organizacao;
}