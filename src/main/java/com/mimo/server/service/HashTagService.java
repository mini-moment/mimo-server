package com.mimo.server.service;

import com.mimo.server.dto.HashTagDto;

import java.util.List;

public interface HashTagService {
    void insertHashTagList(List<HashTagDto> hashtags);
}
