package com.guilda.registro_aventureiros.repository.jpa;

import com.guilda.registro_aventureiros.dto.RankingParticipacaoDto;
import com.guilda.registro_aventureiros.model.operacoes.ParticipacaoMissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ParticipacaoRepository extends JpaRepository<ParticipacaoMissao, Long> {

    // Esta Query resolve o erro do ParticipacaoService
    @Query("SELECT new com.guilda.registro_aventureiros.dto.RankingParticipacaoDto(" +
            "p.aventureiro.id, p.aventureiro.nome, COUNT(p.id), SUM(p.recompensaOuro), " +
            "COUNT(CASE WHEN p.destaqueMvp = true THEN 1 END)) " +
            "FROM ParticipacaoMissao p GROUP BY p.aventureiro.id, p.aventureiro.nome")
    List<RankingParticipacaoDto> findRankingAventureiros();
}