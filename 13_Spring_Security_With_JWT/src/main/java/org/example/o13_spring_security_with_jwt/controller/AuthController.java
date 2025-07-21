package org.example.o13_spring_security_with_jwt.controller;

import lombok.RequiredArgsConstructor;
import org.example.o13_spring_security_with_jwt.dto.ApiResponse;
import org.example.o13_spring_security_with_jwt.dto.AuthDTO;
import org.example.o13_spring_security_with_jwt.dto.RegisterDTO;
import org.example.o13_spring_security_with_jwt.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(
            @RequestBody RegisterDTO registerDTO) {
        return ResponseEntity.ok(new ApiResponse(
                200,
                "OK",
                authService.register(registerDTO)));
    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(
            @RequestBody AuthDTO authDTO) {
        return ResponseEntity.ok(new ApiResponse(
                200,
                "OK",
                authService.authenticate(authDTO)));
    }
}
