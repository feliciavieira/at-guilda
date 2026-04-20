package com.guilda.registro_aventureiros.model.aventura;

import com.guilda.registro_aventureiros.model.enums.Especie;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_companheiros")//um companheiro animal
@Data
public class Companheiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Especie especie;

    @OneToOne
    @JoinColumn(name = "aventureiro_id") //detentora da chave estrangeira
    private Aventureiro aventureiro;
}