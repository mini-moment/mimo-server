package com.mimo.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class PostDto {

    private int id;
    @NonNull
    private String title;
    private int userId;
    @NonNull
    private String videoUrl;
    private int markerId;
    private List<TagDto> tagList;
}
