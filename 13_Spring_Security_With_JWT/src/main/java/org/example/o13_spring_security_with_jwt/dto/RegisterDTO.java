package org.example.o13_spring_security_with_jwt.dto;

import lombok.Data;

@Data
public class RegisterDTO {
    private String username;
    private String password;
    private String role; //USER or ADMIN
}
