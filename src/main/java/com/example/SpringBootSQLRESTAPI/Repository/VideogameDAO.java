package com.example.SpringBootSQLRESTAPI.Repository;

import com.example.SpringBootSQLRESTAPI.Entity.Videogames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideogameDAO extends JpaRepository<Videogames, Integer> {
}
