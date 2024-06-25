package com.mimo.server.dao;

import com.mimo.server.dto.MarkerDto;

import java.util.HashMap;
import java.util.List;

public interface MapDao {


    List<MarkerDto> getMarkers(HashMap<String, Object> map);

    void insertMarker(MarkerDto markerDto);
}
