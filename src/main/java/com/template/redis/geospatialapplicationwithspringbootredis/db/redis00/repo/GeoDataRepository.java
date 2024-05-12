package com.template.redis.geospatialapplicationwithspringbootredis.db.redis00.repo;

import com.template.redis.geospatialapplicationwithspringbootredis.db.redis00.entity.GeoData;
import org.springframework.data.repository.CrudRepository;

public interface GeoDataRepository extends CrudRepository<GeoData, Long> {
}
