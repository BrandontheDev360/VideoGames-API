package com.example.SpringBootSQLRESTAPI.Controller;

import com.example.SpringBootSQLRESTAPI.Entity.VideoGames;
import com.example.SpringBootSQLRESTAPI.Model.Response;
import com.example.SpringBootSQLRESTAPI.Service.VideogameServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.*;

@RestController
public class Controller {
    Logger logger;

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
        return videogameServiceInterface.findVideoGamesByTitleLike(title, pageNum, pageSize);
    }

    @GetMapping("get/videogame/{id}")
    public ResponseEntity<Response> getVideoGame(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .status(OK)
                            .statusCode(OK.value())
                            .message("VideoGame Id: " + id + " successfully retrieved")
                            .data(Map.of("videogame", videogameServiceInterface.getVideoGame(id)))
                            .timestamp(now())
                            .build());
        } catch (Exception e) {
            logger.info("Exception Occurred, Message : " + e.getMessage());
            return ResponseEntity.ok(
                    Response.builder()
                            .status(NOT_FOUND)
                            .statusCode(NOT_FOUND.value())
                            .message("VideoGame Id: " + id + " failed to retrieve")
                            .timestamp(now())
                            .build());
        }
    }

    @GetMapping("get/videogames/{pageNum}/{pageSize}")
    public Map<String, Object> getAllVideoGames(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return videogameServiceInterface.getAllVideoGames(pageNum, pageSize);
    }

    @PostMapping("post/videogame")
    public VideoGames addVideoGame(@RequestBody VideoGames videogame) {
        return videogameServiceInterface.addVideoGame(videogame);
    }

    @PutMapping("update/videogame/{id}")
    public VideoGames updateVideoGame(@PathVariable("id") int id, @RequestBody VideoGames videogame) {
        return videogameServiceInterface.updateVideoGame(id, videogame);
    }

    @DeleteMapping("delete/videogame/{id}")
    String deleteVideoGame(@PathVariable("id") int id) {
        return videogameServiceInterface.deleteVideoGame(id);
    }
}
