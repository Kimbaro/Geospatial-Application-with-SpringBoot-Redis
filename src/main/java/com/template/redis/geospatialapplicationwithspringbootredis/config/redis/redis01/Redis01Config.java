package com.template.redis.geospatialapplicationwithspringbootredis.config.redis.redis01;

import com.template.redis.geospatialapplicationwithspringbootredis.config.redis.configProps.RedisDataSource;
import com.template.redis.geospatialapplicationwithspringbootredis.db.redis00.entity.GeoData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@Slf4j
public class Redis01Config {

    @Bean(name = "redis01Template")
    public RedisTemplate<String, String> redis01Template(@Qualifier("redis01ConnectionFactory") LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    @Bean(name = "redis01ConnectionFactory")
    public LettuceConnectionFactory redis01ConnectionFactory(@Qualifier("redis01RedisDataSource") RedisDataSource redisDataSource) {
        LettuceConnectionFactory lettuceConnectionFactory =
                new LettuceConnectionFactory(redisDataSource.getHOST(), redisDataSource.getPORT());
        lettuceConnectionFactory.setPassword(redisDataSource.getPASSWORD());
        lettuceConnectionFactory.setDatabase(15);
        return lettuceConnectionFactory;
    }

    @Bean(name = "redis01RedisDataSource")
    @ConfigurationProperties(prefix = "spring.datasources.nosql.redis.redis01")
    public RedisDataSource redis01DataSource() {
        return RedisDataSource.builder().build();
    }
}
