package com.example.SpringBootSQLRESTAPI.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class UserResponse {
    private HttpStatus status;
    private int statusCode;
    private String message;
    private List<?> data;
    private LocalDateTime timestamp;
}
