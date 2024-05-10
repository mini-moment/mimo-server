package com.mimo.server.controller;

import com.mimo.server.dto.TagDto;
import com.mimo.server.service.TagService;
import com.mimo.server.util.ApiUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class TagController {

    private final TagService service;

    @GetMapping("tags")
    @Operation(summary = "태그의 정보를 가져옵니다.")
    public ApiUtil.ApiSuccessResult<List<TagDto>> s() {
        return ApiUtil.success(service.getTags());
    }
}
