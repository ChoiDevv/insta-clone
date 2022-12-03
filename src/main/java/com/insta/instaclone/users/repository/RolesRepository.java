package com.insta.instaclone.users.repository;

import com.insta.instaclone.users.repository.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, String> {
}
