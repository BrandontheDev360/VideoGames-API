package com.example.SpringBootSQLRESTAPI.Service.Interfaces;

import com.example.SpringBootSQLRESTAPI.Request.InsertUsersVideogamesRequest;

import java.util.Map;

public interface UsersVideogamesServiceInterface {
    Map<String, Object> insertUsersVideogame(InsertUsersVideogamesRequest request);

    Map<String, Object> getAllUsersVideogamesAssociations();
}
