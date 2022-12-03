package com.insta.instaclone.users.repository;

import com.insta.instaclone.users.repository.domain.Roles;
import com.insta.instaclone.users.repository.domain.Users;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @After
    public void cleanUp() {
        usersRepository.deleteAll();
    }

    @Test
    public void 유저_저장을_테스트합니다() {
        //given
        for (int i = 0; i < 50; i++) {
            LocalDateTime now = LocalDateTime.now();

            if (i <= 20) {
                Users user = new Users("user" + i, now, "phoneNumber" + i, "email" + i,
                        "name" + i, "username" + i, "password" + i);
                usersRepository.save(user);
            }
            else {
                Users user = new Users("user" + i, now, "phoneNumber" + i, "email" + i,
                        "name" + i, "username" + i, "password" + i);
                usersRepository.save(user);
            }
        }
        //when
        List<Users> users = usersRepository.findAll();

        //then
        Users user = users.get(0);
        assertThat(user.getName()).isEqualTo("name0");
        assertThat(user.getUsername()).isEqualTo("username0");
    }
}
