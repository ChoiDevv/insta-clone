package com.insta.instaclone.users.repository;

import com.insta.instaclone.users.dto.UserInfoRequestDto;
import com.insta.instaclone.users.repository.domain.Users;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository usersRepository;

    @After
    public void cleanUp() {
        usersRepository.deleteAll();
    }
}
