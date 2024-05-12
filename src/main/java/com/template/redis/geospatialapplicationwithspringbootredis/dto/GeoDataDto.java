package com.template.redis.geospatialapplicationwithspringbootredis.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class GeoDataDto {
    private UUID uuid = UUID.randomUUID();
    private Double longitude;
    private Double latitude;
}
