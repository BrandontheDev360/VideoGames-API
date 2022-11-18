package com.example.SpringBootSQLRESTAPI.Request;

import lombok.Data;

@Data
public class InsertUsersVideogamesRequest {
    private int userId;

    private int videoGameId;
}
