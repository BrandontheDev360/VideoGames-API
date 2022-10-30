package com.example.SpringBootSQLRESTAPI.Service;

import com.example.SpringBootSQLRESTAPI.Entity.Videogames;

import java.util.List;
import java.util.Map;

public interface VideogameServiceInterface {

    Map<String, Object> getAllVideoGames(int pageNum, int pageSize);

    Videogames getVideoGame(int videoGameID);

    Videogames addVideoGame(Videogames videogame);

    Videogames updateVideoGame(int id, Videogames videogame);

    String deleteVideoGame(int videoGameID);

    Map<String, Object> findVideoGamesByTitleLike(String title, int pageNum, int pageSize);

    Map<String, Object> findVideoGamesByTitle(String title, int pageNum, int pageSize);
}
