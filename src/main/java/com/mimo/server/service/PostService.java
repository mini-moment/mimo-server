package com.mimo.server.service;

import java.util.List;

import com.mimo.server.dto.PostDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface PostService {
    public PostDto insertPost(PostDto post);

    public List<PostDto> getPostsByIds(int[] ids);

    public String saveThumbnail(MultipartFile thumbnail);

    public Resource getThumbnail(String url);
}
