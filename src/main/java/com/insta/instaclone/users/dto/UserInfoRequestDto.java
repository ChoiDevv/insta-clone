package com.insta.instaclone.users.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserInfoRequestDto {

    private String username;
    private String password;
    private String email;
}
