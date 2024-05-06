package com.mimo.server.dto;

public class UserDto {

    private int userId;
    private String userName;
    private String userContact;
    private String accessToken;
    private String refreshToken;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserContact() {
        return userContact;
    }


    public String getAccessToken() {
        return accessToken;
    }


    public String getRefreshToken() {
        return refreshToken;
    }


    public boolean validation() {
        if (this.userContact == null || this.userName == null || this.refreshToken == null || this.accessToken == null) {
            return false;
        }
        return true;
    }
}
