package com.mimo.server.service;

import com.mimo.server.dto.UserDto;

public interface UserService {

    public UserDto getUser(int id);

    public boolean signUp(UserDto user);
}
