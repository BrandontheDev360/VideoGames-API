package com.example.SpringBootSQLRESTAPI.Controller;

import com.example.SpringBootSQLRESTAPI.Entity.VideoGamesEntity;
import com.example.SpringBootSQLRESTAPI.Response.Response;
import com.example.SpringBootSQLRESTAPI.Request.InsertUsersVideogamesRequest;
import com.example.SpringBootSQLRESTAPI.Service.Interfaces.UserServiceInterface;
import com.example.SpringBootSQLRESTAPI.Service.Interfaces.UsersVideogamesServiceInterface;
import com.example.SpringBootSQLRESTAPI.Service.Interfaces.VideogameServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.logging.Logger;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.*;

@RestController
public class Controller {
    Logger logger;

    @Autowired
    VideogameServiceInterface videogameServiceInterface;

    @Autowired
    UserServiceInterface userServiceInterface;

    @Autowired
    UsersVideogamesServiceInterface usersVideogamesServiceInterface;

    @GetMapping("/")
    public String home() {
        return "<HTML><HEAD><H1> VideoGame </H1></HEAD></HTML>";
    }

    @GetMapping("/get-all-users")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(
                userServiceInterface.getAllUsers()
        );
    }

    @GetMapping("/get/video-games-by-title/{title}/{pageNum}/{pageSize}")
    public Map<String, Object> findVideoGamesByTitle(@PathVariable("title") String title, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return videogameServiceInterface.findVideoGamesByTitle(title, pageNum, pageSize);
    }

    @GetMapping("/get/video-games-like/{title}/{pageNum}/{pageSize}")
    public ResponseEntity<Response> findVideoGamesByTitleLike(@PathVariable("title") String title, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .status(OK)
                            .statusCode(OK.value())
                            .message("VideoGame Title: " + title + " successfully retrieved")
                            .data(videogameServiceInterface.findVideoGamesByTitleLike(title, pageNum, pageSize))
                            .timestamp(now())
                            .build());
        } catch (Exception e) {
            return ResponseEntity.ok(
                    Response.builder()
                            .status(NOT_FOUND)
                            .statusCode(NOT_FOUND.value())
                            .message("VideoGame Title: " + title + " failed to retrieve")
                            .timestamp(now())
                            .build());
        }
    }

    @GetMapping("/get/video-games-by-genre/{genre}/{pageNum}/{pageSize}")
    public ResponseEntity<Response> findVideoGamesByGenre(@PathVariable("genre") String genre, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .status(OK)
                            .statusCode(OK.value())
                            .message("VideoGame Genre: " + genre + " successfully retrieved")
                            .data(videogameServiceInterface.findVideoGamesByGenre(genre, pageNum, pageSize))
                            .timestamp(now())
                            .build());
        } catch (Exception e) {
            return ResponseEntity.ok(
                    Response.builder()
                            .status(NOT_FOUND)
                            .statusCode(NOT_FOUND.value())
                            .message("VideoGame Genre: " + genre + " failed to retrieve")
                            .timestamp(now())
                            .build());
        }
    }

    @GetMapping("get/video-game-by/{id}")
    public ResponseEntity<Response> getVideoGameById(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .status(OK)
                            .statusCode(OK.value())
                            .message("VideoGame Id: " + id + " successfully retrieved")
                            .data(Map.of("videogame", videogameServiceInterface.getVideoGameById(id)))
                            .timestamp(now())
                            .build());
        } catch (Exception e) {
            return ResponseEntity.ok(
                    Response.builder()
                            .status(NOT_FOUND)
                            .statusCode(NOT_FOUND.value())
                            .message("VideoGame Id: " + id + " failed to retrieve")
                            .timestamp(now())
                            .build());
        }
    }

    @GetMapping("get/all-video-games-page/{pageNum}/{pageSize}")
    public ResponseEntity<?> getAllVideoGames(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        try {
            return ResponseEntity.ok(videogameServiceInterface.getAllVideoGames(pageNum, pageSize));
        } catch (Exception e) {
            return ResponseEntity.ok(
                    Response.builder()
                            .status(NO_CONTENT)
                            .statusCode(NO_CONTENT.value())
                            .message("Failed to retrieve all VideoGames")
                            .timestamp(now())
                            .build());
        }
    }

    @GetMapping("get/all-video-games-titles/{pageNum}/{pageSize}")
    public ResponseEntity<Response> getAllVideoGamesTitles(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .status(OK)
                            .statusCode(OK.value())
                            .message("Successfully retrieved all VideoGames Titles")
                            .data(videogameServiceInterface.getAllVideoGamesTitles(pageNum, pageSize))
                            .timestamp(now())
                            .build());
        } catch (Exception e) {
            return ResponseEntity.ok(
                    Response.builder()
                            .status(NO_CONTENT)
                            .statusCode(NO_CONTENT.value())
                            .message("Failed to retrieve all VideoGames Titles")
                            .timestamp(now())
                            .build());
        }
    }

    @GetMapping("/get-all-users-videogames-associations")
    public Map<String, Object> getAllUsersVideoGamesAssociations() {
        return usersVideogamesServiceInterface.getAllUsersVideogamesAssociations();
    }

    @GetMapping("/get-users-videogames-associations-by-id/{userId}")
    public Map<String, Object> getAllUsersVideoGamesAssociationsById(@PathVariable("userId") int userId) {
        return usersVideogamesServiceInterface.getAllUsersVideogamesAssociationsById(userId);
    }


    @PostMapping("post/videogame")
    public ResponseEntity<Response> addVideoGame(@RequestBody VideoGamesEntity videogame) {
        try {
            return ResponseEntity.ok(
                    Response.builder()
                            .status(OK)
                            .statusCode(OK.value())
                            .message("Successfully Added VideoGame: " + videogame.getTitle())
                            .data(Map.of("videogame", videogameServiceInterface.addVideoGame(videogame)))
                            .timestamp(now())
                            .build());
        } catch (Exception e) {
            return ResponseEntity.ok(
                    Response.builder()
                            .status(BAD_REQUEST)
                            .statusCode(BAD_REQUEST.value())
                            .message("Failed to add VideoGame with title " + videogame.getTitle())
                            .timestamp(now())
                            .build());
        }
    }

    @PostMapping("insert-users-videogame")
    public Map<String, Object> insertUsersVideogame (@RequestBody InsertUsersVideogamesRequest request) {
        return usersVideogamesServiceInterface.insertUsersVideogame(request);
    }

    @PutMapping("update/videogame/{id}")
    public VideoGamesEntity updateVideoGame(@PathVariable("id") int id, @RequestBody VideoGamesEntity videogame) {
        return videogameServiceInterface.updateVideoGame(id, videogame);
    }

    @DeleteMapping("delete/videogame/{id}")
    String deleteVideoGame(@PathVariable("id") int id) {
        return videogameServiceInterface.deleteVideoGame(id);
    }

}
