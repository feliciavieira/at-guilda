package com.guilda.registro_aventureiros;

import com.guilda.registro_aventureiros.model.audit.Usuario;
import com.guilda.registro_aventureiros.model.aventura.Aventureiro;
import com.guilda.registro_aventureiros.model.aventura.Organizacao;
import com.guilda.registro_aventureiros.model.enums.Classe; // IMPORTANTE
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

// Este é o import que faz o assertThat funcionar:
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest // Configura um banco em memória para testar apenas o JPA
public class AventureiroMappingTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @DisplayName("Deve validar se o mapeamento de Aventureiro com Organização e Usuário está correto")
    void deveValidarMapeamentoAventureiro() {
        // 1. Cenário: Criar a base (Organização e Usuário do schema audit)
        Organizacao org = new Organizacao();
        org.setNome("Guilda dos Magos");
        entityManager.persist(org);

        Usuario prof = new Usuario();
        prof.setUsername("mestre_da_guilda");
        prof.setSenha("123456");
        prof.setOrganizacao(org);
        entityManager.persist(prof);

        // 2. Ação: Criar o Aventureiro (schema aventura)
        Aventureiro aventureiro = new Aventureiro();
        aventureiro.setNome("Legolas");
        aventureiro.setClasse(Classe.ARQUEIRO);
        aventureiro.setNivel(5);
        aventureiro.setOrganizacao(org);
        aventureiro.setUsuarioResponsavel(prof); // Requisito do professor!

        Aventureiro salvo = entityManager.persistFlushFind(aventureiro);

        // 3. Validação: O Hibernate conseguiu salvar e ler respeitando as constraints?
        assertThat(salvo.getId()).isNotNull();
        assertThat(salvo.getOrganizacao().getNome()).isEqualTo("Guilda dos Magos");
        assertThat(salvo.getUsuarioResponsavel().getUsername()).isEqualTo("mestre_da_guilda");

        System.out.println(">>> TESTE PASSOU: Mapeamento entre Schemas 'audit' e 'aventura' validado com sucesso!");
    }
}