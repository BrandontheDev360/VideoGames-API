package com.example.SpringBootSQLRESTAPI.Model;

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
    protected HttpStatus status;
    protected int statusCode;
    protected String message;
    protected Map<?, ?> data;
    protected Object currentPage;
    protected Object totalPages;
    protected LocalDateTime timestamp;

}
