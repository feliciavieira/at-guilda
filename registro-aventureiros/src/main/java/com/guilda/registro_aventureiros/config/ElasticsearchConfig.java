package com.guilda.registro_aventureiros.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.guilda.registro_aventureiros.repository.elastic")
public class ElasticsearchConfig {
    // Esta classe avisa ao Spring onde procurar os repositórios do Elastic
}