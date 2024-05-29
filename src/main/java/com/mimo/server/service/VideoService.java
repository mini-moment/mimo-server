package com.mimo.server.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface VideoService {
	public String saveVideo(MultipartFile uploadFile);
	public Resource getVideo(String url);
}
