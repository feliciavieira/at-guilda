package com.guilda.registro_aventureiros.service;

import com.guilda.registro_aventureiros.dto.AventureiroCadastroRequestDto;
import com.guilda.registro_aventureiros.dto.AventureiroResumoDto;
import com.guilda.registro_aventureiros.model.aventura.Aventureiro;
import com.guilda.registro_aventureiros.document.RegistroLog; // Documento Mongo
import com.guilda.registro_aventureiros.repository.jpa.AventureiroRepository;
import com.guilda.registro_aventureiros.repository.mongo.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AventureiroService {

    private final AventureiroRepository aventureiroRepository;
    private final LogRepository logRepository;

    @Transactional
    public AventureiroResumoDto registrarNovoAventureiro(AventureiroCadastroRequestDto dto) {
        if (aventureiroRepository.existsByNomeIgnoreCase(dto.getNome())) {
            throw new RuntimeException("Este aventureiro já está registrado na guilda!");
        }

        Aventureiro aventureiro = new Aventureiro();
        aventureiro.setNome(dto.getNome());
        aventureiro.setClasse(dto.getClasse());
        aventureiro.setNivel(dto.getNivel());
        aventureiro.setAtivo(true);

        Aventureiro salvo = aventureiroRepository.save(aventureiro);

        // Registro de Log no MongoDB
        RegistroLog log = new RegistroLog();
        log.setMensagem("CADASTRO: Aventureiro " + salvo.getNome() + " registrado.");
        log.setDataHora(LocalDateTime.now());
        logRepository.save(log);

        return new AventureiroResumoDto(
                salvo.getId(),
                salvo.getNome(),
                salvo.getClasse(),
                salvo.getNivel(),
                salvo.isAtivo()
        );
    }
    //Para otimizar a performance no nível do Hibernate e do banco de dados
    @Transactional(readOnly = true)
    public Page<AventureiroResumoDto> listarPaginado(Pageable paginacao) {
        return aventureiroRepository.findAll(paginacao)
                .map(a -> new AventureiroResumoDto(
                        a.getId(),
                        a.getNome(),
                        a.getClasse(),
                        a.getNivel(),
                        a.isAtivo()
                ));
    }
}