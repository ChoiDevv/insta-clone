package com.insta.instaclone.users.service;

import com.insta.instaclone.users.dto.UserInfoRequestDto;
import com.insta.instaclone.users.repository.UsersRepository;
import com.insta.instaclone.users.repository.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    @Transactional
    public String signUp(UserInfoRequestDto userInfoRequestDto) throws IllegalAccessException {
        validateDuplicatedUser(userInfoRequestDto.getUsername());
        Users info = Users.signUp(userInfoRequestDto.getPhoneNumber(), userInfoRequestDto.getEmail(), userInfoRequestDto.getName(),
                userInfoRequestDto.getUsername(), userInfoRequestDto.getPassword());
        return usersRepository.save(info).getId();
    }

    private void validateDuplicatedUser(String username) {
        if (usersRepository.existsByUsername(username)) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }
}
