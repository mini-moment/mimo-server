package com.mimo.server.service;

import com.mimo.server.dao.MapDao;
import com.mimo.server.dto.MarkerDto;
import com.mimo.server.util.MybatisConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class MapServiceImpl implements MapService {
    @Override
    public List<MarkerDto> getMarkers(HashMap<String, Object> map) {
        try (SqlSession session = MybatisConfig.getSqlSession();) {
            MapDao dao = session.getMapper(MapDao.class);
            return dao.getMarkers(map);
        }
    }

    @Override
    public void insertMarker(MarkerDto markerDto) {
        try (SqlSession session = MybatisConfig.getSqlSession();) {
            MapDao dao = session.getMapper(MapDao.class);
            dao.insertMarker(markerDto);
        }
    }
}
