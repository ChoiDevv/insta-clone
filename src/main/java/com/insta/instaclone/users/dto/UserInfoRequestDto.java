package com.insta.instaclone.users.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoRequestDto {

    private String phoneNumber;
    private String email;
    private String name;
    private String username;
    private String password;

    @Builder
    public UserInfoRequestDto(String phoneNumber, String email, String name, String username, String password) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
    }
}
