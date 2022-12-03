package com.insta.instaclone.users.repository.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "insta_roles")
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
public class Roles {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(columnDefinition = "varchar(32)")
    private String id;

    @CreatedDate
    @Column
    private LocalDateTime createdDate;

    @Column
    private String name;

    @Column
    private String description;

    public Roles(String id, LocalDateTime createdDate, String name, String description) {
        this.id = id;
        this.createdDate = createdDate;
        this.name = name;
        this.description = description;
    }
}
