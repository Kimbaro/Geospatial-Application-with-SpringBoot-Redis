package com.template.redis.geospatialapplicationwithspringbootredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@EnableConfigurationProperties
@ConfigurationPropertiesScan
public class GeospatialApplicationWithSpringBootRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeospatialApplicationWithSpringBootRedisApplication.class, args);
	}
}
