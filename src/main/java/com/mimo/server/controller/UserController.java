package com.mimo.server.controller;

import com.mimo.server.dto.UserDto;
import com.mimo.server.service.UserService;
import com.mimo.server.util.ApiUtil;
import com.mimo.server.util.ApiUtil.ApiSuccessResult;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/login")
    @Operation(summary = "유저의 정보를 바탕으로 로그인 합니다.")
    public ApiSuccessResult<Boolean> login(@RequestBody UserDto userDto) {
        log.debug("user : {}", userDto);
        return ApiUtil.success(service.login(userDto));
    }

    @GetMapping("/getUser/{id}")
    @Operation(summary = "id에 해당하는 User를 반환합니다")
    public UserDto getUser(@PathVariable int id) {
        UserDto user = service.getUserById(id);
        log.debug("user : {}", user);
        return user;
    }

    @DeleteMapping("/unRegister")
    @Operation(summary = "현재 User를 삭제합니다.")
    public ApiSuccessResult<Boolean> unRegister(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        UserDto user = service.getUserByAccessToken(authorizationHeader);
        return ApiUtil.success(service.unRegister(user.getId()));
    }
}
