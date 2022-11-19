package com.example.SpringBootSQLRESTAPI.Controller;

import com.example.SpringBootSQLRESTAPI.Entity.VideoGamesEntity;
import com.example.SpringBootSQLRESTAPI.Service.Interfaces.VideogameServiceInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    @Autowired
    VideogameServiceInterface videogameServiceInterface;


    @Test
    void home() {

    }

    @Test
    void findVideoGamesByTitle() {
    }

    @Test
    void getAllVideoGames() {
    }

    @Test
    void addVideoGame() {
    }

    @Test
    void deleteVideoGame() {
    }

    @Test
    void findByGenre() {
        VideoGamesEntity sample = new VideoGamesEntity(1, "Test", "RPG");
        videogameServiceInterface.addVideoGame(sample);
        VideoGamesEntity result = videogameServiceInterface.findByGenre("RPG");
        assertNotNull(result);
    }
}