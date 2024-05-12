package com.template.redis.geospatialapplicationwithspringbootredis.controller;

import com.template.redis.geospatialapplicationwithspringbootredis.dto.GeoDataDto;
import com.template.redis.geospatialapplicationwithspringbootredis.service.GeoDataServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final GeoDataServiceImpl geoDataService;

    @GetMapping("/find-all-ip")
    public String findAllIp() {
        return geoDataService.findAll().toString();
    }

    @GetMapping("/near-by")
    public ResponseEntity<String> findIp(
            @RequestParam(name = "longitude") Double longitude,
            @RequestParam(name = "latitude") Double latitude,
            @RequestParam(name = "km") Double km) {

        geoDataService.nearBy(longitude, latitude, km);
        return ResponseEntity.ok("");
    }

    @PostMapping("/save-new-location")
    public ResponseEntity<GeoDataDto> saveGeoData(@RequestBody GeoDataDto geoDataDto) {
        return ResponseEntity.ok(geoDataService.save(geoDataDto));
//        return geoDataService.findByUUID(String.valueOf(geoDataDto.getUuid())).toString();
    }
}
