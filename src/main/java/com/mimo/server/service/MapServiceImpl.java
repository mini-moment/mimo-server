package com.mimo.server.service;

import com.mimo.server.dao.MapDao;
import com.mimo.server.dto.MapDto;
import com.mimo.server.util.MybatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapServiceImpl implements MapService {
    @Override
    public List<MapDto> getMarkers(Long latitude, Long longitude, Double radius) {
        try (SqlSession session = MybatisConfig.getSqlSession();) {
            MapDao dao = session.getMapper(MapDao.class);
            return dao.getMarkers(latitude, longitude, radius);
        }
    }
}
