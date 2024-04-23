package com.mimo.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mimo.server.dto.UserDto;
import com.mimo.server.dto.VideoDto;
import com.mimo.server.service.UserService;
import com.mimo.server.service.VideoService;

@RestController
public class VideoController {
	
	@Autowired
	VideoService service;

	
	@GetMapping("/{videoId}/download")
    public ResponseEntity<Resource> downloadVideo(@PathVariable Long videoId) {

        Resource videoFile = service.loadVideo(videoId);
        
        // 적절한 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=video.mp4");
        
        // 파일과 헤더를 포함한 ResponseEntity 반환
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("video/mp4"))
                .body(videoFile);
    }
}


