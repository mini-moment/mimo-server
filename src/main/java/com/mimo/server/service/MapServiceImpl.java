package com.mimo.server.service;

import com.mimo.server.dao.MapDao;
import com.mimo.server.dto.MapDto;
import com.mimo.server.dto.PostDto;
import com.mimo.server.util.MybatisConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class MapServiceImpl implements MapService {
    @Override
    public List<PostDto> getMarkers(HashMap<String, Object> map) {
        try (SqlSession session = MybatisConfig.getSqlSession();) {
            MapDao dao = session.getMapper(MapDao.class);
            return dao.getMarkers(map);
        }
    }
}
