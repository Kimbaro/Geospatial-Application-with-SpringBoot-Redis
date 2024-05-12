package com.template.redis.geospatialapplicationwithspringbootredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
@EnableAutoConfiguration(exclude = RedisReactiveAutoConfiguration.class)
public class GeospatialApplicationWithSpringBootRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeospatialApplicationWithSpringBootRedisApplication.class, args);
	}
}
