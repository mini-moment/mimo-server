package com.mimo.server.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class HashTagDto {

    private int id;
    private int postId;
    private int tagId;

    public HashTagDto(int postId, int tagId) {
        this.postId = postId;
        this.tagId = tagId;
    }
}
