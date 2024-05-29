package com.mimo.server.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mimo.server.error.CustomErrorCode;
import com.mimo.server.error.CustomException;

@Service
public class VideoServiceImpl implements VideoService{
	
	@Value("${path.videoStoragePath}")
	private String videoStoragePath;

	@Override
	public String saveVideo(MultipartFile uploadFile) {
		UUID uuid = UUID.randomUUID();
		String filename = uuid + "_" + uploadFile.getOriginalFilename();
		String filepath = videoStoragePath + "/" + filename;
		File file = new File(filepath);
		
		try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bos.write(uploadFile.getBytes());
            bos.close();
        
        } catch (Exception e) {
        	throw new CustomException(CustomErrorCode.VIDEO_UPLOAD_SERVER_ERROR);
        } 
		return filename;
	}

	@Override
	public Resource getVideo(String url) {
		String path = videoStoragePath + "/" + url;
		Resource resource =  new FileSystemResource(path);
		
        return resource;
	}
}
