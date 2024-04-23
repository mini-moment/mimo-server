package com.mimo.server.service;

import org.springframework.core.io.Resource;

public interface VideoService {
	public Resource loadVideo(Long videoId);
}
