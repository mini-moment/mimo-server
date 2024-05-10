package com.mimo.server.dao;

import com.mimo.server.dto.TagDto;

import java.util.List;

public interface TagDao {
    public List<TagDto> getTags();
}
