package com.guilda.registro_aventureiros.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class ConfiguracaoCache {

    @Bean
    public CacheManager cacheManager(){
        // Mudei o nome do identificador do cache de "topMissoes" para "cache_painel_tatico"
        return new ConcurrentMapCacheManager("cache_painel_tatico");
    }

    // Mantive os 5 minutos (300.000ms), mas mudei o nome do método de limpeza
    @Scheduled(fixedRate = 300000)
    @CacheEvict(value = "cache_painel_tatico", allEntries = true)
    public void resetarCacheSetorial() {
        System.out.println("Limpando memória temporária do Painel Tático...");
    }
}