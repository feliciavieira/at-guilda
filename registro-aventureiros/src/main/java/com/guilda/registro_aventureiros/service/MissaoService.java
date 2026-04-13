package com.guilda.registro_aventureiros.service;

import com.guilda.registro_aventureiros.dto.MissaoListagemDto;
import com.guilda.registro_aventureiros.model.operacoes.Missao; // Import correto
import com.guilda.registro_aventureiros.model.enums.StatusMissao;
import com.guilda.registro_aventureiros.model.operacoes.PainelTaticoMissao;
import com.guilda.registro_aventureiros.repository.jpa.MissaoRepository;
import com.guilda.registro_aventureiros.repository.jpa.PainelTaticoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissaoService {

    private final MissaoRepository missaoRepository;
    private final PainelTaticoRepository painelRepository;

    @Cacheable(value = "cache_painel_tatico")
    public List<PainelTaticoMissao> buscarTopMissoes() {
        return painelRepository.findAll().stream()
                .limit(10)
                .collect(Collectors.toList());
    }

    @Transactional
    @CacheEvict(value = "cache_painel_tatico", allEntries = true)
    public MissaoListagemDto criarMissao(String titulo) {
        Missao missao = new Missao();
        missao.setTitulo(titulo);
        missao.setStatus(StatusMissao.PLANEJADA);
        // O campo na sua Entity é dataCriacao (da auditoria) ou setCreatedAt manual?
        // Ajustei para o que estava no seu DTO:
        Missao salva = missaoRepository.save(missao);
        return new MissaoListagemDto(salva.getId(), salva.getTitulo(), salva.getStatus(), LocalDateTime.now());
    }

    @Transactional
    public void concluirMissao(Long id) {
        Missao missao = missaoRepository.findById(id).orElseThrow();
        missao.setStatus(StatusMissao.CONCLUIDA);
        missaoRepository.save(missao);
    }
}