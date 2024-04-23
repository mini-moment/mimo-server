package com.mimo.server.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.mimo.server.dao.UserDao;
import com.mimo.server.dto.UserDto;
import com.mimo.server.util.MybatisConfig;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public UserDto getUser(int id) {
		try (SqlSession session = MybatisConfig.getSqlSession();){
            UserDao dao = session.getMapper(UserDao.class);

            UserDto dto = dao.getUser(id);
          
            return dto;
        }
	}
	
}
