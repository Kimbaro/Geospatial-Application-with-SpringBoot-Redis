package com.template.redis.geospatialapplicationwithspringbootredis.config.redis.redis00;

import com.template.redis.geospatialapplicationwithspringbootredis.config.redis.configProps.RedisDataSource;
import com.template.redis.geospatialapplicationwithspringbootredis.db.redis00.entity.GeoData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.Duration;

import static java.util.Collections.singletonMap;

@Configuration
@Slf4j
/**
 * https://medium.com/@raphael3213/multiple-redis-connections-in-spring-boot-37f632e8e64f
 * */
public class Redis00Config {

    @Bean(name = "redis00Template")
    public RedisTemplate<String, Object> redis00Template(@Qualifier("redis00ConnectionFactory") LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    @Bean(name = "redis00ConnectionFactory")
    public LettuceConnectionFactory redis00ConnectionFactory(@Qualifier("redis00RedisDataSource") RedisDataSource redisDataSource) {
        LettuceConnectionFactory lettuceConnectionFactory =
                new LettuceConnectionFactory(redisDataSource.getHOST(), redisDataSource.getPORT());
        lettuceConnectionFactory.setDatabase(14);
        return lettuceConnectionFactory;
    }

    @Bean(name = "redis00RedisDataSource")
    @ConfigurationProperties(prefix = "spring.datasources.nosql.redis.redis00")
    public RedisDataSource redis01DataSource() {
        return RedisDataSource.builder().build();
    }
}
