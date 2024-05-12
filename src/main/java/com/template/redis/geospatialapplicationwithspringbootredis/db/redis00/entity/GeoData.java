package com.template.redis.geospatialapplicationwithspringbootredis.db.redis00.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.UUID;

@Data
@RedisHash(value = "geoData")
@Builder
public class GeoData implements Serializable {
    @Id
    private UUID uuid = UUID.randomUUID();
    private String longitude;
    private String latitude;
}
