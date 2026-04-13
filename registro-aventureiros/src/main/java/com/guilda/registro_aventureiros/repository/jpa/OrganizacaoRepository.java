package com.guilda.registro_aventureiros.repository.jpa;

import com.guilda.registro_aventureiros.model.aventura.Organizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface OrganizacaoRepository extends JpaRepository<Organizacao, Long> {
    Optional<Organizacao> findByNomeIgnoreCase(String nome);
}