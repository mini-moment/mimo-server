package com.mimo.server.dao;

import com.mimo.server.dto.UserDto;
import com.mimo.server.dto.VideoDto;

public interface UserDao {
	public UserDto getUser(int id);
}
