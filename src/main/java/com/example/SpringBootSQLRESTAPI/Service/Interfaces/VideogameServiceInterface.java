package com.example.SpringBootSQLRESTAPI.Service.Interfaces;

import com.example.SpringBootSQLRESTAPI.Entity.VideoGames;
import com.example.SpringBootSQLRESTAPI.Model.getAllVideoGamesResponse;
import org.springframework.beans.support.PagedListHolder;

import java.util.List;
import java.util.Map;

public interface VideogameServiceInterface {

    getAllVideoGamesResponse getAllVideoGames(int pageNum, int pageSize);

    VideoGames getVideoGameById(int videoGameID);

    VideoGames addVideoGame(VideoGames videogame);

    VideoGames updateVideoGame(int id, VideoGames videogame);

    String deleteVideoGame(int videoGameID);

    Map<String, Object> findVideoGamesByTitleLike(String title, int pageNum, int pageSize);

    Map<String, Object> findVideoGamesByTitle(String title, int pageNum, int pageSize);

    Map<String, Object> findVideoGamesByGenre(String genre, int pageNum, int pageSize);

    Map<String, Object> getAllVideoGamesTitles(int pageNum, int pageSize);

    VideoGames findByGenre(String genre);

//    PagedListHolder<Object> getAllVideoGamesTitles(int pageNum, int pageSize);
}
