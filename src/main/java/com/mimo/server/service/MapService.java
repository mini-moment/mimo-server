package com.mimo.server.service;

import com.mimo.server.dto.MapDto;
import com.mimo.server.dto.PostDto;

import java.util.*;

public interface MapService {

    List<PostDto> getMarkers(HashMap<String, Object> location);
}
