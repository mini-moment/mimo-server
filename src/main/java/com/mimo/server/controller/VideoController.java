package com.mimo.server.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mimo.server.service.VideoService;
import com.mimo.server.util.ApiUtil;
import com.mimo.server.util.ApiUtil.ApiSuccessResult;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/video")
@RequiredArgsConstructor
public class VideoController {
	
	private final VideoService service;
	
	@PostMapping("/upload")
	@Operation(summary = "동영상 파일을 업로드 합니다.")
	public ApiSuccessResult<String> uploadVideo(@RequestParam("video") MultipartFile uploadFile, HttpServletRequest req){
        return ApiUtil.success(service.saveVideo(uploadFile));
	}

	@GetMapping(path="display/{url}")
	@Operation(summary = "요청받은 url의 동영상 파일을 반환합니다.")
	public ResponseEntity<Resource> display(@PathVariable String url, HttpServletRequest req){	
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Type", "video/mp4");
		
        return new ResponseEntity<>(service.getVideo(url), httpHeaders, HttpStatus.OK);
	}
}
