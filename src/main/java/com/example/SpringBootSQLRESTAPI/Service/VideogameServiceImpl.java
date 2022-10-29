package com.example.SpringBootSQLRESTAPI.Service;

import com.example.SpringBootSQLRESTAPI.Entity.Videogames;
import com.example.SpringBootSQLRESTAPI.Repository.VideogameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class VideogameServiceImpl implements VideogameServiceInterface {

    @Autowired
    public VideogameDAO videogameDAO;

    @Override
    public List<Videogames> getAllVideogames(int pageNum, int pageSize) {
        return videogameDAO.findAll(PageRequest.of(pageNum,pageSize)).toList();
    }

    @Override
    public Videogames getVideogame(int videoGameID) {
        Optional<Videogames> optional = videogameDAO.findById(videoGameID);
        Videogames videogame = null;
        if (optional.isPresent()) {
            videogame = optional.get();
        } else {
            System.out.println("VideoGame not found for id :" + videoGameID);
        }
        return videogame;
    }

    @Override
    public Videogames addVideoGame(Videogames videogame) {
        return this.videogameDAO.save(videogame);
    }

    @Override
    public Videogames updateVideoGame(int id, Videogames videogame) {
        Optional<Videogames> videogameData = videogameDAO.findById(id);
        Videogames updateVideoGame = new Videogames();
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
    public Map<String, Object> findVideogamesByTitleLike(String title, int pageNum, int pageSize) {
        Pageable paging = PageRequest.of(pageNum, pageSize);
        Page<Videogames> pagedResult = videogameDAO.findByTitleLikeIgnoreCase(title, paging);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("videogames", pagedResult.getContent());
        response.put("currentpage", pagedResult.getNumber() + 1);
        response.put("totalpages", pagedResult.getTotalPages());
        return response;
    }

    @Override
    public Map<String, Object> findVideoGamesByTitle(String title, int pageNum, int pageSize) {
        Pageable paging = PageRequest.of(pageNum, pageSize);
        Page<Videogames> pagedResult = videogameDAO.findByTitle(title, paging);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("videogames", pagedResult.getContent());
        response.put("currentpage", pagedResult.getNumber() + 1);
        response.put("totalpages", pagedResult.getTotalPages());
        return response;
    }

}
