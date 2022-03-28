package com.example.SpringBootSQLRESTAPI.Controller;

import com.example.SpringBootSQLRESTAPI.Entity.Videogames;
import com.example.SpringBootSQLRESTAPI.Service.VideogameServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    VideogameServiceInterface videogameServiceInterface;

    @GetMapping("/")
    public String home() {
        return "<HTML><HEAD><H1> VideoGame </H1></HEAD></HTML>";
    }

    @GetMapping("/videogame/{id}")
    public Videogames getVideogame(@PathVariable("id") int id) {
        return videogameServiceInterface.getVideogame(id);
    }

    @GetMapping("/videogames")
    public List<Videogames> getAllVideoGames() {
        return videogameServiceInterface.getAllVideogames();
    }

    @PostMapping("/videogame")
    public Videogames addVideoGame(@RequestBody Videogames videogame) {
        return videogameServiceInterface.addVideoGame(videogame);
    }

    @PutMapping("/videogame/{id}")
    public Videogames updateRecipe(@PathVariable("id") @RequestBody Videogames videogame) {
        return videogameServiceInterface.updateVideoGame(videogame);
    }

    @DeleteMapping("/recipes/{id}")
    String deleteVideoGame(@PathVariable("id") int id) {
        return videogameServiceInterface.deleteVideoGame(id);
    }
}
