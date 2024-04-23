package com.mimo.server.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService{

    public Resource loadVideo(Long videoId) {
        // videoId에 해당하는 동영상 파일 경로를 얻어온다고 가정
        String videoFilePath = getVideoFilePath(videoId);
        
        // 파일 시스템 리소스를 생성하여 동영상 파일을 읽어들임
        return new FileSystemResource(videoFilePath);
    }
    
    private String getVideoFilePath(Long videoId) {
        // videoId를 이용하여 동영상 파일 경로를 얻어오는 로직을 구현
        // 실제로는 데이터베이스 조회 등을 통해 파일 경로를 가져올 것입니다.
        // 여기서는 단순히 가상의 파일 경로를 반환하는 것으로 가정합니다.
        return "/path/to/videos/video_" + videoId + ".mp4";
    }
}
