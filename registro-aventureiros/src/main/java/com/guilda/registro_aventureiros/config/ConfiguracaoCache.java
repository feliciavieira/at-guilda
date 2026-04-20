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
        return new ConcurrentMapCacheManager("cache_painel_tatico");
    }

    @Scheduled(fixedRate = 300000)
    @CacheEvict(value = "cache_painel_tatico", allEntries = true)
    public void resetarCacheSetorial() {
        System.out.println("Limpando memória temporária do Painel Tático...");
    }
}