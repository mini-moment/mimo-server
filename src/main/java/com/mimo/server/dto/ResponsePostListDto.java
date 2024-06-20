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
    private int userId;
    private String videoUrl;
    private int markerId;
    private List<TagDto> tagList;
    private String videoThumbnailUrl;
    private UserDto userInfo;
}
