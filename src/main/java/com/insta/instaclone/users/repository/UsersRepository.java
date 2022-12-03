package com.insta.instaclone.users.repository;

import com.insta.instaclone.users.repository.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
}
