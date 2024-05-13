package com.mimo.server.service;

import com.mimo.server.dao.HashTagDao;
import com.mimo.server.dto.HashTagDto;
import com.mimo.server.error.CustomErrorCode;
import com.mimo.server.error.CustomException;
import com.mimo.server.util.MybatisConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class HashTagServiceImpl implements HashTagService {

    @Override
    public void insertHashTagList(List<HashTagDto> hashtags) {
        try (SqlSession session = MybatisConfig.getSqlSession();) {
            HashTagDao dao = session.getMapper(HashTagDao.class);
            for (HashTagDto hashtag : hashtags) {
                int result = dao.insertHashTag(hashtag);
                if (result != 1) {
                    throw new CustomException(CustomErrorCode.INVALID_DATA_FORMAT);
                }
            }
        }
    }
}
