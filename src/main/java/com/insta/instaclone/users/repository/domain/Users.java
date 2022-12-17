package com.insta.instaclone.users.repository.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@NoArgsConstructor
@Table(name = "insta_users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String role;

    public Users(String username, String password, String email, String role) {
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.email = email;
        this.role = role;
    }
}
