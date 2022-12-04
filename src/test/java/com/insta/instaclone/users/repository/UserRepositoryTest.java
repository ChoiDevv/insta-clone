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
    private UsersRepository usersRepository;

    @After
    public void cleanUp() {
        usersRepository.deleteAll();
    }

    @Test
    public void 유저_저장을_테스트합니다() {
        UserInfoRequestDto info = UserInfoRequestDto.builder()
                .phoneNumber("phoneNumber")
                .email("email")
                .name("name")
                .username("username")
                .password("password")
                .build();

        Users user = new Users(info.getPhoneNumber(), info.getEmail(), info.getPhoneNumber(), info.getUsername(), info.getPassword());
        usersRepository.save(user);

        //when
        List<Users> usersList = usersRepository.findAll();

        //then
        Users users = usersList.get(0);
        assertThat(users.getPhoneNumber()).isEqualTo("phoneNumber");
    }
}
