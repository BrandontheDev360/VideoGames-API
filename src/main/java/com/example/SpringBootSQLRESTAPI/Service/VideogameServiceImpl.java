package com.example.SpringBootSQLRESTAPI.Service;

import com.example.SpringBootSQLRESTAPI.Entity.Videogames;
import com.example.SpringBootSQLRESTAPI.Repository.VideogameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideogameServiceImpl implements VideogameServiceInterface {

    @Autowired
    public VideogameDAO videogameDAO;

    @Override
    public List<Videogames> getAllVideogames() {
        return this.videogameDAO.findAll();
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
        Videogames updateVideoGame = null;
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
    public List<Videogames> findVideogamesByTitle(String title) {
        return videogameDAO.findByTitle(title);
    }
}
