package com.template.redis.geospatialapplicationwithspringbootredis.service;

import com.template.redis.geospatialapplicationwithspringbootredis.db.redis00.entity.GeoData;
import com.template.redis.geospatialapplicationwithspringbootredis.dto.GeoDataDto;
import com.template.redis.geospatialapplicationwithspringbootredis.service.impl.GeoDataService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.domain.geo.GeoLocation;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
@Slf4j
public class GeoDataServiceImpl implements GeoDataService {
    private final String KEY = "GeoData";

    @Qualifier("redis01Template")
    private final RedisTemplate<String, String> redisTemplate;

    private GeoOperations<String, String> geoOperations;

    @PostConstruct
    private void init() {
        geoOperations = redisTemplate.opsForGeo();
    }

    @Override
    public Map<String, String> findAll() {
        return null;
    }

    @Override
    public GeoDataDto save(GeoDataDto geoDataDto) {
        Point point = new Point(geoDataDto.getLongitude(), geoDataDto.getLatitude());
        geoOperations.add(KEY, point, geoDataDto.getUuid().toString());
        return geoDataDto;
    }

    @Override
    public GeoData nearBy(Double longitude, Double latitude, Double km) {
        Circle circle = new Circle(new Point(longitude, latitude), new Distance(km, Metrics.KILOMETERS));
        GeoResults<RedisGeoCommands.GeoLocation<String>> res = geoOperations.radius(KEY, circle);
        GeoResults<RedisGeoCommands.GeoLocation<String>> results = geoOperations
                .search("geoPoints", circle);
        results.getContent().stream().forEach(System.out::println);
        
        return null;
    }

    @Override
    public void delete(String companyId) {

    }
}
