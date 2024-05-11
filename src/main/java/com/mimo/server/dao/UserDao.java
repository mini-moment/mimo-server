package com.mimo.server.dao;

import com.mimo.server.dto.UserDto;

public interface UserDao {

    public UserDto getUserByAccessToken(int id);

    public boolean signUp(UserDto user);

    public UserDto getUserByAccessToken(String accessToken);
}
