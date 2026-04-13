package com.guilda.registro_aventureiros.repository.jpa;

import com.guilda.registro_aventureiros.model.operacoes.PainelTaticoMissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PainelTaticoRepository extends JpaRepository<PainelTaticoMissao, Long> {
    Optional<PainelTaticoMissao> findByDataReferencia(LocalDate data);
}