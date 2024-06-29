package com.mimo.server.dao;

import java.util.List;

import com.mimo.server.dto.ResponsePostListDto;
import org.apache.ibatis.annotations.Param;

import com.mimo.server.dto.PostDto;

public interface PostDao {
	public PostDto getPost(int id);

	public boolean insertPost(PostDto post);
	
	public List<ResponsePostListDto> searchPostsByIds(@Param("array") int[] ids);

	public int[] searchPostsIdsByAccessToken(String accessToken);
}
