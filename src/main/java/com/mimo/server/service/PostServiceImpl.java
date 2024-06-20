package com.mimo.server.service;

import com.mimo.server.dao.PostDao;
import com.mimo.server.dto.PostDto;
import com.mimo.server.dto.ResponsePostListDto;
import com.mimo.server.error.CustomErrorCode;
import com.mimo.server.error.CustomException;
import com.mimo.server.util.MybatisConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    @Value("${path.thumbnailStoragePath}")
    private String thumbnailStoragePath;

    @Override
    public PostDto insertPost(PostDto post) {
        try (SqlSession session = MybatisConfig.getSqlSession();) {
            PostDao dao = session.getMapper(PostDao.class);
            dao.insertPost(post);
            return post;
        }
    }

    @Override
    public List<ResponsePostListDto> getPostsByIds(int[] ids) {
        try (SqlSession session = MybatisConfig.getSqlSession();) {
            PostDao dao = session.getMapper(PostDao.class);
            return dao.searchPostsByIds(ids);
        }
    }

    @Override
    public String saveThumbnail(MultipartFile thumbnail) {
        UUID uuid = UUID.randomUUID();
        String filename = uuid + "_" + thumbnail.getOriginalFilename();
        String filePath = thumbnailStoragePath + "/" + filename;
        File file = new File(filePath);
        try (InputStream inputStream = thumbnail.getInputStream()) {
            Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new CustomException(CustomErrorCode.IMAGE_UPLOAD_SERVER_ERROR);
        }
        return filename;
    }

    @Override
    public Resource getThumbnail(String url) {
        String path = thumbnailStoragePath + "/" + url;
        return new FileSystemResource(path);
    }
}
