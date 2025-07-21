package org.example.o13_spring_security_with_jwt.config;

import lombok.RequiredArgsConstructor;
import org.example.o13_spring_security_with_jwt.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username ->
                userRepository.findByUsername(username)
                        .map(user ->
                                new org.springframework.security
                                        .core.userdetails.User(
                                user.getUsername(),
                                user.getPassword(),
                                List.of(new SimpleGrantedAuthority
                                        ("ROLE_"+user.getRole()
                                                .name()))
                        )).orElseThrow(
                                ()->new UsernameNotFoundException
                                        ("User not found")
                        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
