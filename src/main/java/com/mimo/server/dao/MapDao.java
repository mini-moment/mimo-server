package com.mimo.server.dao;

import com.mimo.server.dto.MapDto;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface MapDao {


    List<MapDto> getMarkers(HashMap<String, Object> map);
}
