package com.mimo.server.service;

import com.mimo.server.dto.MapDto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MapServiceImpl implements MapService {
    @Override
    public List<MapDto> getMarkers(Long latitude, Long longitude, Double radius) {
        return Collections.emptyList();
    }
}
