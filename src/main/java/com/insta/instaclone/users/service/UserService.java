package com.insta.instaclone.users.service;

import com.insta.instaclone.users.dto.UserInfoRequestDto;
import com.insta.instaclone.users.repository.UserRepository;
import com.insta.instaclone.users.repository.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Long create(UserInfoRequestDto dto) {
        String role = "ROLE_USER";
        Users user = new Users(dto.getUsername(), dto.getPassword(), dto.getEmail(), role);
        return userRepository.save(user).getId();
    }
}
