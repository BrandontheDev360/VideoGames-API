package com.example.SpringBootSQLRESTAPI.Service;

import com.example.SpringBootSQLRESTAPI.Entity.VideoGames;
import org.springframework.beans.support.PagedListHolder;

import java.util.List;
import java.util.Map;

public interface VideogameServiceInterface {

    Map<String, Object> getAllVideoGames(int pageNum, int pageSize);

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
