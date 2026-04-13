package com.guilda.registro_aventureiros.service;

import com.guilda.registro_aventureiros.dto.RankingParticipacaoDto;
import com.guilda.registro_aventureiros.repository.jpa.ParticipacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipacaoService {

    private final ParticipacaoRepository participacaoRepository;

    public List<RankingParticipacaoDto> gerarRanking() {
        // Este método precisa existir para o Controller parar de dar erro
        return participacaoRepository.findRankingAventureiros();
    }
}