package com.guilda.registro_aventureiros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableJpaRepositories(basePackages = "com.guilda.registro_aventureiros.repository.jpa")
@EnableMongoRepositories(basePackages = "com.guilda.registro_aventureiros.repository.mongo")
public class RegistroAventureirosApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegistroAventureirosApplication.class, args);
	}
}