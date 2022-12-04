package com.insta.instaclone.users.repository.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@NoArgsConstructor
@Table(name = "insta_users")
public class Users {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(columnDefinition = "varchar(32)")
    private String id;

    @CreatedDate
    @Column
    private LocalDateTime createdDate;

    @Column
    private String phoneNumber;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String username;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus role;

    @Builder
    public Users(String id, LocalDateTime createdDate, String phoneNumber, String email, String name, String username,
                 String password, UserStatus role) throws IllegalAccessException {
        this.id = id;
        this.createdDate = createdDate;
        validateUserInfo(phoneNumber, email, name, username, password);
        this.role = role;;
    }



    private void validateUserInfo(String phoneNumber, String email, String name, String username, String password) throws IllegalAccessException {
        if (!Objects.equals(phoneNumber, "") && !Objects.equals(email, "") && !Objects.equals(name, "") && !Objects.equals(username, "") && !Objects.equals(password, "")) {
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.name = name;
            this.username = username;
            this.password = password;
        } else {
            throw new IllegalAccessException("한 개라도 빈 값이어서는 안됩니다.");
        }
    }

    public Users(String phoneNumber, String email, String name, String username, String password) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Users(String id, LocalDateTime createdDate, String phoneNumber, String email, String name, String username, String password) {
        this.id = id;
        this.createdDate = createdDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public static Users signUp(String phoneNumber, String email, String name, String username, String password) throws IllegalAccessException {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return Users.builder()
                .phoneNumber(phoneNumber)
                .email(email)
                .name(name)
                .username(username)
                .password(bCryptPasswordEncoder.encode(password))
                .role(UserStatus.ROLE_USER)
                .build();
    }
}
