package com.insta.instaclone.config;

import com.insta.instaclone.users.repository.UsersRepository;
import com.insta.instaclone.users.repository.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("등록되지 않은 사용자입니다."));

        CustomUserDetails details = new CustomUserDetails();
        details.setUser(user);
        return details;
    }
}
