package com.mimo.server.service;

import com.mimo.server.dto.UserDto;

public interface UserService {

    public UserDto getUserByAccessToken(int id);

    public boolean signUp(UserDto user);

    public UserDto getUserByAccessToken(String accessToken);
}
