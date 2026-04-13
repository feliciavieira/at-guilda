package com.guilda.registro_aventureiros.repository.jpa;

import com.guilda.registro_aventureiros.model.operacoes.Missao;
import com.guilda.registro_aventureiros.model.enums.GrauPerigo;
import com.guilda.registro_aventureiros.model.enums.StatusMissao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MissaoRepository extends JpaRepository<Missao, Long> {

    Page<Missao> findByStatus(StatusMissao status, Pageable pageable);

    // Busca missões de alto risco que ainda não foram concluídas
    @Query("SELECT m FROM Missao m WHERE m.nivelPerigo IN (com.guilda.registro_aventureiros.model.enums.GrauPerigo.ALTO, com.guilda.registro_aventureiros.model.enums.GrauPerigo.CRITICO) AND m.status != 'CONCLUIDA'")
    List<Missao> buscarMissoesUrgentes();

    // Conta quantas missões uma organização já criou
    long countByOrganizacaoId(Long orgId);
}