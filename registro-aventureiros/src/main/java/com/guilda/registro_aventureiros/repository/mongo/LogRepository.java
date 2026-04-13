package com.guilda.registro_aventureiros.repository.mongo;

import com.guilda.registro_aventureiros.document.RegistroLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LogRepository extends MongoRepository<RegistroLog, String> {

    // Busca logs de um tipo específico (ex: "ERROR")
    List<RegistroLog> findByTipo(String tipo);

    // Busca logs de um usuário específico para rastrear ações
    List<RegistroLog> findByUsuarioOrderByDataHoraDesc(String usuario);

    // Busca logs em um intervalo de tempo (para auditoria)
    List<RegistroLog> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);

    // Conta quantos erros aconteceram nas últimas 24h
    long countByTipoAndDataHoraAfter(String tipo, LocalDateTime tempo);
}