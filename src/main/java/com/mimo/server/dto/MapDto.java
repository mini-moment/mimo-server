package com.mimo.server.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MapDto {

    public int id;
    public int postId;
    public Double latitude;
    public Double longitude;
}
