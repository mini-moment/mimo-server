package com.mimo.server.dao;

import com.mimo.server.dto.MapDto;
import com.mimo.server.dto.PostDto;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface MapDao {


    List<PostDto> getMarkers(HashMap<String, Object> map);
}
