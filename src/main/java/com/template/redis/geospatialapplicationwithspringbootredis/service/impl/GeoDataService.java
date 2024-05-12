package com.template.redis.geospatialapplicationwithspringbootredis.service.impl;

import com.template.redis.geospatialapplicationwithspringbootredis.db.redis00.entity.GeoData;
import com.template.redis.geospatialapplicationwithspringbootredis.dto.GeoDataDto;

import java.util.Map;

public interface GeoDataService {

    public Map<String, String> findAll();

    public GeoDataDto save(GeoDataDto geoDataDto);

    public GeoData nearBy(Double longitude, Double latitude, Double km);

    public void delete(String companyId);

}
