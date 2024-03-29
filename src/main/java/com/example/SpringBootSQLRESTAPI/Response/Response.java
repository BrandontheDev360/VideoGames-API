package com.example.SpringBootSQLRESTAPI.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private HttpStatus status;
    private int statusCode;
    private String message;
    private Map<?, ?> data;
    private LocalDateTime timestamp;
}
