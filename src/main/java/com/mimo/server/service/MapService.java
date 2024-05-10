package com.mimo.server.service;

import com.mimo.server.dto.MapDto;
import java.util.*;

public interface MapService {

    List<MapDto> getMarkers(HashMap<String, Object> location);
}
