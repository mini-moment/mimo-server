package com.mimo.server.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResponsePostListDto {

    private int id;
    private String title;
    private String videoUrl;
    private List<TagDto> tagList;
    private String videoThumbnailUrl;
    private UserDto userInfo;
    private String uploadTime;
}
