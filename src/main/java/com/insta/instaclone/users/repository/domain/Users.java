package com.insta.instaclone.users.repository.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private List<Roles> roles;

    public Users(String id, LocalDateTime createdDate, String phoneNumber, String email, String name, String username,
                 String password) {
        this.id = id;
        this.createdDate = createdDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.name = name;
        this.username = username;
        this.password = password;
    }
}
