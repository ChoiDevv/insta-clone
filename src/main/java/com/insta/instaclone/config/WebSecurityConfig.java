package com.insta.instaclone.config;

import com.insta.instaclone.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    public void configure(WebSecurity web) { // 4
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable()
                        .authorizeRequests()
                            .antMatchers("/main/**")
                            .authenticated()
                        .anyRequest()
                            .permitAll()
                        .and()
                        .formLogin()
                            .loginPage("/sign-in")
                            .loginProcessingUrl("/login")
                            .defaultSuccessUrl("/main");

        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(encodePassword());
    }
}
