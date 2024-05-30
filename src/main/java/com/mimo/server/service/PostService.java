package com.mimo.server.service;

import java.util.List;

import com.mimo.server.dto.PostDto;

public interface PostService {
    public PostDto insertPost(PostDto post);
    public List<PostDto> getPostsByIds(int[] ids);
}
