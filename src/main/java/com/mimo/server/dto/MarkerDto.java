package com.mimo.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MarkerDto {

    public int id;
    public int postId;
    public Double latitude;
    public Double longitude;
}
