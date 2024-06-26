package com.mimo.server.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class UserDto {

    private int id;
    private String userName;
    private String userContact;
    private String accessToken;
    private String refreshToken;
    private String profileImageUrl;

    public boolean validation() {
        if (this.userContact == null || this.userName == null || this.refreshToken == null || this.accessToken == null || this.profileImageUrl == null) {
            return false;
        }
        return true;
    }
}
