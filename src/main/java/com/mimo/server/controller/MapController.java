package com.mimo.server.controller;

import com.mimo.server.dto.MarkerDto;
import com.mimo.server.service.MapService;
import com.mimo.server.util.ApiUtil;
import com.mimo.server.util.ApiUtil.ApiSuccessResult;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@Slf4j
@ControllerAdvice
public class MapController {


    @Autowired
    MapService service;


    @GetMapping("/markers")
    @Operation(summary = "위도, 경도, radius에 따른 마커들을 전달해줍니다.")
    public ApiSuccessResult<List<MarkerDto>> getMarkers(Double latitude, Double longitude, Double radius) {
        try {
            HashMap<String, Object> location = new HashMap<>();
            location.put("latitude", latitude);
            location.put("longitude", longitude);
            location.put("radius", radius);
            List<MarkerDto> markers = service.getMarkers(location);
            log.debug("markers : {}", markers);
            return ApiUtil.success(markers);
        } catch (Exception e) {
            throw e;
        }
    }
}
