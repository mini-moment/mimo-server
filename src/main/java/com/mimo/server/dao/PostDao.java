package com.mimo.server.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mimo.server.dto.PostDto;

public interface PostDao {
	public PostDto getPost(int id);

	public boolean insertPost(PostDto post);
	
	public List<PostDto> searchPostsByIds(@Param("array") int[] ids);
}
