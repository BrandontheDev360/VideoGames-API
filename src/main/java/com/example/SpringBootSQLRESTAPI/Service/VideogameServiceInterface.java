package com.example.SpringBootSQLRESTAPI.Service;

import com.example.SpringBootSQLRESTAPI.Entity.Videogames;

import java.util.List;

public interface VideogameServiceInterface {
    List<Videogames> getAllVideogames();

    Videogames getVideogame(int videoGameID);

    Videogames addVideoGame(Videogames videogame);

    Videogames updateVideoGame(int id, Videogames videogame);

    String deleteVideoGame(int videoGameID);
}
