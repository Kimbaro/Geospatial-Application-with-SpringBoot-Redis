package com.template.redis.geospatialapplicationwithspringbootredis.db.redis00.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash(value = "ipTableCache")
@Builder
public class GeoData implements Serializable {
    @Id
    private String uuid;
    private String longitude;
    private String latitude;
    private String geoHash;
}
