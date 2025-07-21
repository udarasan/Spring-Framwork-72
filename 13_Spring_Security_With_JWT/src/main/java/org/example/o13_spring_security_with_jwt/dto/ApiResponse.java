package org.example.o13_spring_security_with_jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private int code;
    private String status;
    private Object data;
}
