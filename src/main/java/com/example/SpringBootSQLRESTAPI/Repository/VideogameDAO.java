package com.example.SpringBootSQLRESTAPI.Repository;

import com.example.SpringBootSQLRESTAPI.Entity.Videogames;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideogameDAO extends PagingAndSortingRepository<Videogames, Integer> {
    List<Videogames> findByTitle(String title, Pageable page);
}
