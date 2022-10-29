package com.example.SpringBootSQLRESTAPI.Controller;

import com.example.SpringBootSQLRESTAPI.Entity.Videogames;
import com.example.SpringBootSQLRESTAPI.Service.VideogameServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    VideogameServiceInterface videogameServiceInterface;

    @GetMapping("/")
    public String home() {
        return "<HTML><HEAD><H1> VideoGame </H1></HEAD></HTML>";
    }

    @GetMapping("/get/video-games-by/{title}/{pageNum}/{pageSize}")
    public Map<String, Object> findVideoGamesByTitle(@PathVariable("title") String title, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return videogameServiceInterface.findVideoGamesByTitle(title, pageNum, pageSize);
    }

    @GetMapping("/get/video-games-like/{title}/{pageNum}/{pageSize}")
    public Map<String, Object> findVideoGamesByTitleLike(@PathVariable("title") String title, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return videogameServiceInterface.findVideogamesByTitleLike(title, pageNum, pageSize);
    }

    @GetMapping("get/videogame/{id}")
    public Videogames getVideogame(@PathVariable("id") int id) {
        return videogameServiceInterface.getVideogame(id);
    }

    @GetMapping("get/videogames/{pageNum}/{pageSize}")
    public List<Videogames> getAllVideoGames(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return videogameServiceInterface.getAllVideogames(pageNum, pageSize);
    }

    @PostMapping("post/videogame")
    public Videogames addVideoGame(@RequestBody Videogames videogame) {
        return videogameServiceInterface.addVideoGame(videogame);
    }

    @PutMapping("update/videogame/{id}")
    public Videogames updateVideoGame(@PathVariable("id") int id, @RequestBody Videogames videogame) {
        return videogameServiceInterface.updateVideoGame(id, videogame);
    }

    @DeleteMapping("delete/videogame/{id}")
    String deleteVideoGame(@PathVariable("id") int id) {
        return videogameServiceInterface.deleteVideoGame(id);
    }
}
