package com.mimo.server.controller;

import com.mimo.server.dto.UserDto;
import com.mimo.server.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService service;

    @PostMapping("/signUp")
    @Operation(summary = "유저의 정보를 바탕으로 회원가입을 합니다.")
    public boolean signUp(@RequestBody UserDto userDto) {
        return service.signUp(userDto);
    }

    @GetMapping("/getUser/{id}")
    @Operation(summary = "id에 해당하는 User를 반환합니다")
    public UserDto getUser(@PathVariable int id) {
        try {
            UserDto user = service.getUser(id);
            logger.debug("user : {}", user);
            return user;
        } catch (Exception e) {
            throw e;
        }
    }
}
