package com.mimo.server.dao;

import com.mimo.server.dto.MapDto;

import java.util.List;

public interface MapDao {


    List<MapDto> getMarkers(Long latitude, Long longitude, Double radius);
}
