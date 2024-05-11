package com.mimo.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostDto {

    private int id;
    @NonNull
    private String title;
    private int userId;
    @NonNull
    private String videoUrl;
    private long latitude;
    private long longitude;
    private List<TagDto> tagList;
}
