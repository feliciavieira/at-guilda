package com.guilda.registro_aventureiros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {
		MongoAutoConfiguration.class,
		MongoDataAutoConfiguration.class,
		RedisAutoConfiguration.class
})
@EnableCaching
@EnableScheduling
@EnableJpaRepositories(basePackages = "com.guilda.registro_aventureiros.repository.jpa")
// @EnableMongoRepositories(basePackages = "com.guilda.registro_aventureiros.repository.mongo")
public class RegistroAventureirosApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegistroAventureirosApplication.class, args);
	}
}