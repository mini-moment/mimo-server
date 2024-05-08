package com.mimo.server.service;

import com.mimo.server.dao.TagDao;
import com.mimo.server.dto.TagDto;
import com.mimo.server.util.MybatisConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TagServiceImpl implements TagService {
    @Override
    public List<TagDto> getTags() {
        try (SqlSession session = MybatisConfig.getSqlSession();) {
            TagDao dao = session.getMapper(TagDao.class);
            return dao.getTags();
        }
    }
}
