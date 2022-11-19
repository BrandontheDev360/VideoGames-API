package com.example.SpringBootSQLRESTAPI.Repository;

import com.example.SpringBootSQLRESTAPI.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDAO extends JpaRepository<UserEntity, Integer> {
}
