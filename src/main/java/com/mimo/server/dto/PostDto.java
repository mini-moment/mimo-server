package com.mimo.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostDto {

    private int id;
    @NonNull
    private String title;
    private int userId;
    @NonNull
    private String videoUrl;
    private List<TagDto> tagList;
    private String thumbnailUrl;
    private String uploadTime;
}
