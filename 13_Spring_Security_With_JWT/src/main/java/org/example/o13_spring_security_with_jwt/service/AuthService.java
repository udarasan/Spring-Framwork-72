package org.example.o13_spring_security_with_jwt.service;

import lombok.RequiredArgsConstructor;
import org.example.o13_spring_security_with_jwt.dto.AuthDTO;
import org.example.o13_spring_security_with_jwt.dto.AuthResponseDTO;
import org.example.o13_spring_security_with_jwt.dto.RegisterDTO;
import org.example.o13_spring_security_with_jwt.entity.Role;
import org.example.o13_spring_security_with_jwt.entity.User;
import org.example.o13_spring_security_with_jwt.repository.UserRepository;
import org.example.o13_spring_security_with_jwt.util.JwtUtil;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthResponseDTO authenticate(AuthDTO authDTO) {
        User user=
                userRepository.findByUsername(authDTO.getUsername())
                        .orElseThrow(
                                ()->new UsernameNotFoundException
                                        ("Username not found"));
        if (!passwordEncoder.matches(
                authDTO.getPassword(),
                user.getPassword())) {
            throw new BadCredentialsException("Incorrect password");
        }
        String token=jwtUtil.generateToken(authDTO.getUsername());
        return  new AuthResponseDTO(token);
    }
    public String register(RegisterDTO  registerDTO) {
        if(userRepository.findByUsername(
                registerDTO.getUsername()).isPresent()){
            throw new RuntimeException("Username already exists");
        }
        User user=User.builder()
                .username(registerDTO.getUsername())
                .password(passwordEncoder.encode(
                        registerDTO.getPassword()))
                .role(Role.valueOf(registerDTO.getRole()))
                .build();
        userRepository.save(user);
        return  "User Registration Success";
    }
}
