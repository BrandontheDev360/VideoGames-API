package com.example.SpringBootSQLRESTAPI.Service;

import com.example.SpringBootSQLRESTAPI.Entity.VideoGames;
import com.example.SpringBootSQLRESTAPI.Repository.VideogameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class VideogameServiceImpl implements VideogameServiceInterface {

    @Autowired
    public VideogameDAO videogameDAO;

    @Override
    public Map<String, Object> getAllVideoGames(int pageNum, int pageSize) {
        Pageable page = PageRequest.of(pageNum, pageSize);
        Page<VideoGames> pagedResult = videogameDAO.findAll(page);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("videogames", pagedResult.getContent());
        response.put("currentpage", pagedResult.getNumber() + 1);
        response.put("totalpages", pagedResult.getTotalPages());
        return response;
    }

    @Override
    public VideoGames getVideoGameById(int videoGameID) {
        Optional<VideoGames> optional = videogameDAO.findById(videoGameID);
        VideoGames videogame = null;
        if (optional.isPresent()) {
            videogame = optional.get();
        } else {
            System.out.println("VideoGame not found for id :" + videoGameID);
        }
        return videogame;
    }

    @Override
    public VideoGames addVideoGame(VideoGames videogame) {
        return this.videogameDAO.save(videogame);
    }

    @Override
    public VideoGames updateVideoGame(int id, VideoGames videogame) {
        Optional<VideoGames> videogameData = videogameDAO.findById(id);
        VideoGames updateVideoGame = new VideoGames();
        if(videogameData.isPresent()) {
            updateVideoGame = videogameData.get();
            updateVideoGame.setTitle(videogame.getTitle());
            updateVideoGame.setGenre(videogame.getGenre());
            return this.videogameDAO.save(updateVideoGame);
        } else {
            return updateVideoGame;
        }
    }

    @Override
    public String deleteVideoGame(int videoGameID) {
        videogameDAO.deleteById(videoGameID);
        return "Delete VideoGame ID: " + videoGameID;
    }

    @Override
    public Map<String, Object> findVideoGamesByTitleLike(String title, int pageNum, int pageSize) {
        Pageable paging = PageRequest.of(pageNum, pageSize);
        Page<VideoGames> pagedResult = videogameDAO.findByTitleLikeIgnoreCase(title, paging);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("videogames", pagedResult.getContent());
        response.put("currentpage", pagedResult.getNumber() + 1);
        response.put("totalpages", pagedResult.getTotalPages());
        return response;
    }

    @Override
    public Map<String, Object> findVideoGamesByTitle(String title, int pageNum, int pageSize) {
        Pageable paging = PageRequest.of(pageNum, pageSize);
        Page<VideoGames> pagedResult = videogameDAO.findByTitle(title, paging);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("videogames", pagedResult.getContent());
        response.put("currentpage", pagedResult.getNumber() + 1);
        response.put("totalpages", pagedResult.getTotalPages());
        return response;
    }

    @Override
    public Map<String, Object> findVideoGamesByGenre(String genre, int pageNum, int pageSize) {
        Pageable page = PageRequest.of(pageNum, pageSize);
        Page<VideoGames> pagedResult = videogameDAO.findByGenreLikeIgnoreCase(genre, page);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("videogames", pagedResult.getContent());
        response.put("currentpage", pagedResult.getNumber() + 1);
        response.put("totalpages", pagedResult.getTotalPages());
        return response;
    }

}
