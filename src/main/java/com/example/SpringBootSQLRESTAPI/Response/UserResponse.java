package com.example.SpringBootSQLRESTAPI.Response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserResponse {
    private HttpStatus status;
    private int statusCode;
    private String message;
    private List<?> data;
    private LocalDateTime timestamp;
}
