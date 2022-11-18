package com.example.SpringBootSQLRESTAPI.Repository;

import com.example.SpringBootSQLRESTAPI.Entity.UsersVideogameEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsersVideogamesDAO extends JpaRepository<UsersVideogameEntity, Integer> {
}
