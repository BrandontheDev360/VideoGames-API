package com.example.SpringBootSQLRESTAPI.Service.Interfaces;

import com.example.SpringBootSQLRESTAPI.Entity.VideoGamesEntity;
import com.example.SpringBootSQLRESTAPI.Response.GetAllVideoGamesResponse;

import java.util.Map;

public interface VideogameServiceInterface {

    GetAllVideoGamesResponse getAllVideoGames(int pageNum, int pageSize);

    VideoGamesEntity getVideoGameById(int videoGameID);

    VideoGamesEntity addVideoGame(VideoGamesEntity videogame);

    VideoGamesEntity updateVideoGame(int id, VideoGamesEntity videogame);

    String deleteVideoGame(int videoGameID);

    Map<String, Object> findVideoGamesByTitleLike(String title, int pageNum, int pageSize);

    Map<String, Object> findVideoGamesByTitle(String title, int pageNum, int pageSize);

    Map<String, Object> findVideoGamesByGenre(String genre, int pageNum, int pageSize);

    Map<String, Object> getAllVideoGamesTitles(int pageNum, int pageSize);

    VideoGamesEntity findByGenre(String genre);

//    PagedListHolder<Object> getAllVideoGamesTitles(int pageNum, int pageSize);
}
