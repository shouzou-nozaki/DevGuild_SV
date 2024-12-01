package com.example.devguild_sv.dto;

public class UserInfoDTO {
    private int userId;
    private String userName;

    public UserInfoDTO(int userId, String userName) {
        this.userId = userId;     // ユーザーID
        this.userName = userName; // ユーザー名
    }

    // ユーザーID
    public int getUserId() {
        return userId;
    }
    // ユーザ―名
    public String getUserName() {
        return userName;
    }
}
