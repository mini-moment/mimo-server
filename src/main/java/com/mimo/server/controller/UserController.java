package com.mimo.server.controller;

import com.mimo.server.dto.UserDto;
import com.mimo.server.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/signUp")
    @Operation(summary = "유저 회원가입")
    public boolean signUp(@RequestBody UserDto userDto) {
        return service.signUp(userDto);
    }
}
