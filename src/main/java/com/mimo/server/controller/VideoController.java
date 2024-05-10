package com.mimo.server.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mimo.server.error.CustomErrorCode;
import com.mimo.server.error.CustomException;
import com.mimo.server.service.VideoService;
import com.mimo.server.util.ApiUtil;
import com.mimo.server.util.ApiUtil.ApiSuccessResult;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/video")
@RequiredArgsConstructor
public class VideoController {
	
	private final VideoService service;
	private final String videoStoragePath = System.getProperty("user.dir").toString() + "/video";	// videoPath Directory Path
	ServletContext servletContext;

	@PostMapping("/upload")
	public ApiSuccessResult<String> uploadVideoFile(
			@RequestParam("video")
			MultipartFile uploadFile, HttpServletRequest req){
		
		UUID uuid = UUID.randomUUID();
		String filename = uuid.toString() + "_" + uploadFile.getOriginalFilename();
		String filepath = videoStoragePath + "/" + filename;
		File file = new File(filepath);
		
		try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bos.write(uploadFile.getBytes());
            bos.close();
        
        } catch (Exception e) {
        	throw new CustomException(CustomErrorCode.VIDEO_UPLOAD_SERVER_ERROR);
        } 
        return ApiUtil.success(filename);
	}
	
	@GetMapping("/download")
	public ResponseEntity<InputStreamResource> downloadFile(String url, HttpServletRequest req) throws Exception{
        File file = new File(videoStoragePath + "/" + url);
        InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
        
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .contentLength(file.length())
                .body(isr);
	}
	
	@GetMapping("display/{url}")
	public ResponseEntity<?> display(@PathVariable String url, HttpServletRequest req) throws Exception{
		String path = videoStoragePath + "/" + url;
		Resource resource =  new FileSystemResource(path);
		HttpHeaders httpHeaders = new HttpHeaders();
        try {
            Path filepath = Paths.get(path);
            httpHeaders.add("Content-Type", Files.probeContentType(filepath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        return new ResponseEntity<>(resource, httpHeaders, HttpStatus.OK);
	}
}


