package com.mimo.server.service;

import com.mimo.server.dto.MarkerDto;

import java.util.*;

public interface MapService {

    List<MarkerDto> getMarkers(HashMap<String, Object> location);
    void insertMarker(MarkerDto markerDto);
}
