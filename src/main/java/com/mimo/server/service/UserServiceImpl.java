package com.mimo.server.service;

import com.mimo.server.dao.UserDao;
import com.mimo.server.dto.UserDto;
import com.mimo.server.error.CustomException;
import com.mimo.server.util.MybatisConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import static com.mimo.server.error.CustomErrorCode.INVALID_DATA_FORMAT;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDto getUserByAccessToken(int id) {
        try (SqlSession session = MybatisConfig.getSqlSession();) {
            UserDao dao = session.getMapper(UserDao.class);
            return dao.getUserByAccessToken(id);
        }
    }

    @Override
    public boolean signUp(UserDto user) {
        if (!user.validation()) {
            throw new CustomException(INVALID_DATA_FORMAT);
        }
        try (SqlSession session = MybatisConfig.getSqlSession();) {
            UserDao dao = session.getMapper(UserDao.class);
            return dao.signUp(user);
        }
    }

    @Override
    public UserDto getUserByAccessToken(String accessToken) {
        try (SqlSession session = MybatisConfig.getSqlSession();) {
            UserDao dao = session.getMapper(UserDao.class);
            return dao.getUserByAccessToken(accessToken);
        }
    }
}
