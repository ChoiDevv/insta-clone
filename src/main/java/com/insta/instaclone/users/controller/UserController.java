package com.insta.instaclone.users.controller;

import com.insta.instaclone.users.dto.UserInfoRequestDto;
import com.insta.instaclone.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/v1/sign-up")
    public Long create(@RequestBody UserInfoRequestDto dto) {
        return userService.create(dto);
    }
}
