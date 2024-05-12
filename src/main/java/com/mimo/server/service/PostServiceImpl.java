package com.mimo.server.service;

import com.mimo.server.dao.PostDao;
import com.mimo.server.dto.PostDto;
import com.mimo.server.util.MybatisConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostServiceImpl implements PostService {
    @Override
    public PostDto insertPost(PostDto post) {
        try (SqlSession session = MybatisConfig.getSqlSession();) {
            PostDao dao = session.getMapper(PostDao.class);
            dao.insertPost(post);
            return post;
        }
    }
}
