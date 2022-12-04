package com.insta.instaclone.users.repository;

import com.insta.instaclone.users.repository.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, String> {
    boolean existsByUsername(String username);
    Optional<Users> findByUsername(String username);
}
