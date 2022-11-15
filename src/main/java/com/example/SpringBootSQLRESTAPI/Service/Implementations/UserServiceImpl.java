package com.example.SpringBootSQLRESTAPI.Service.Implementations;

import com.example.SpringBootSQLRESTAPI.Entity.User;
import com.example.SpringBootSQLRESTAPI.Model.UserResponse;
import com.example.SpringBootSQLRESTAPI.Repository.UserDAO;
import com.example.SpringBootSQLRESTAPI.Service.Interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    UserDAO userDAO;

    @Override
    public UserResponse getAllUsers() {
        UserResponse response = new UserResponse();
        List<User> listOfUsers = userDAO.findAll();
        response.setStatus(HttpStatus.OK);
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Successfully retrieved all Users");
        response.setData(listOfUsers);
        response.setTimestamp(LocalDateTime.now());
        return response;
    }
}
