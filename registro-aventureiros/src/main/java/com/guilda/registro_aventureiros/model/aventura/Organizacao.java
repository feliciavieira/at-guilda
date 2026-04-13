package com.guilda.registro_aventureiros.model.aventura;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "organizacoes")
@Data
public class Organizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    private String localizacao;
}