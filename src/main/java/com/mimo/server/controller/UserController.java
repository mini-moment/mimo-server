package com.mimo.server.controller;

import com.mimo.server.dto.UserDto;
import com.mimo.server.service.UserService;
import com.mimo.server.util.ApiUtil;
import com.mimo.server.util.ApiUtil.ApiSuccessResult;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@ControllerAdvice
public class UserController {


    @Autowired
    UserService service;

    @PostMapping("/signUp")
    @Operation(summary = "유저의 정보를 바탕으로 회원가입을 합니다.")
    public ApiSuccessResult<Boolean> signUp(@RequestBody UserDto userDto) {
        return ApiUtil.success(service.signUp(userDto));
    }

    @GetMapping("/getUser/{id}")
    @Operation(summary = "id에 해당하는 User를 반환합니다")
    public UserDto getUser(@PathVariable int id) {
        try {
            UserDto user = service.getUser(id);
            log.debug("user : {}", user);
            return user;
        } catch (Exception e) {
            throw e;
        }
    }
}
