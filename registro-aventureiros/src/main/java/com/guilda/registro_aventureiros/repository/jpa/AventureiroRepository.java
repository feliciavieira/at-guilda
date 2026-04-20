package com.guilda.registro_aventureiros.repository.jpa;

import com.guilda.registro_aventureiros.model.aventura.Aventureiro;
import com.guilda.registro_aventureiros.model.enums.Classe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AventureiroRepository extends JpaRepository<Aventureiro, Long> {

    Page<Aventureiro> findByClasse(Classe classe, Pageable pageable);

    Page<Aventureiro> findByAtivoTrue(Pageable pageable);

    // Busca customizada: Aventureiros com nível acima de X e que pertencem a uma organização específica
    @Query("SELECT a FROM Aventureiro a WHERE a.nivel >= :nivel AND a.organizacao.id = :orgId")
    Page<Aventureiro> buscarElitePorOrganizacao(Integer nivel, Long orgId, Pageable pageable);

    //Método para verificar se o nome já existe
    boolean existsByNomeIgnoreCase(String nome);
}