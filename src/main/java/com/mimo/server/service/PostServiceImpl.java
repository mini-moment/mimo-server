package com.mimo.server.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.mimo.server.dao.PostDao;
import com.mimo.server.dto.PostDto;
import com.mimo.server.util.MybatisConfig;

import lombok.extern.slf4j.Slf4j;

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

	@Override
	public List<PostDto> getPostsByIds(int[] ids) {
		try (SqlSession session = MybatisConfig.getSqlSession();) {
            PostDao dao = session.getMapper(PostDao.class);
            return dao.searchPostsByIds(ids);
        }
	}
}
