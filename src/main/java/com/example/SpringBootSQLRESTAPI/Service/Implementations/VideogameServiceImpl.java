package com.example.SpringBootSQLRESTAPI.Service.Implementations;

import com.example.SpringBootSQLRESTAPI.Entity.VideoGames;
import com.example.SpringBootSQLRESTAPI.Model.getAllVideoGamesResponse;
import com.example.SpringBootSQLRESTAPI.Repository.VideogameDAO;
import com.example.SpringBootSQLRESTAPI.Service.Interfaces.VideogameServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class VideogameServiceImpl implements VideogameServiceInterface {

    @Autowired
    public VideogameDAO videogameDAO;

    @Autowired
    private EntityManager em;

    @Override
    public getAllVideoGamesResponse getAllVideoGames(int pageNum, int pageSize) {
        Pageable page = PageRequest.of(pageNum - 1, pageSize);
        Page<VideoGames> pagedResult = videogameDAO.findAll(page);
        getAllVideoGamesResponse response = new getAllVideoGamesResponse();
        response.setStatus(HttpStatus.OK);
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Successfully retrieved all Video Games");
        response.setData(pagedResult.getContent());
        response.setCurrentPage(pagedResult.getNumber() + 1);
        response.setTotalPages(pagedResult.getTotalPages());
        response.setTimestamp(LocalDateTime.now());
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
        Pageable paging = PageRequest.of(pageNum - 1, pageSize);
        Page<VideoGames> pagedResult = videogameDAO.findByTitleLikeIgnoreCase(title, paging);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("videogames", pagedResult.getContent());
        response.put("currentpage", pagedResult.getNumber() + 1);
        response.put("totalpages", pagedResult.getTotalPages());
        return response;
    }

    @Override
    public Map<String, Object> findVideoGamesByTitle(String title, int pageNum, int pageSize) {
        Pageable paging = PageRequest.of(pageNum - 1, pageSize);
        Page<VideoGames> pagedResult = videogameDAO.findByTitle(title, paging);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("videogames", pagedResult.getContent());
        response.put("currentpage", pagedResult.getNumber() + 1);
        response.put("totalpages", pagedResult.getTotalPages());
        return response;
    }

    @Override
    public Map<String, Object> findVideoGamesByGenre(String genre, int pageNum, int pageSize) {
        Pageable page = PageRequest.of(pageNum - 1, pageSize);
        Page<VideoGames> pagedResult = videogameDAO.findByGenreLikeIgnoreCase(genre, page);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("videogames", pagedResult.getContent());
        response.put("currentpage", pagedResult.getNumber() + 1);
        response.put("totalpages", pagedResult.getTotalPages());
        return response;
    }

    @Override
    public Map<String, Object> getAllVideoGamesTitles(int pageNum, int pageSize) {
        StoredProcedureQuery storedProcedureQuery = em.createStoredProcedureQuery("sp_Get_Video_Games_Titles");
        List<Object[]> results = storedProcedureQuery.getResultList();
        PagedListHolder<Object[]> pagedResult = new PagedListHolder<>(results);
        pagedResult.setPage(pageNum - 1);
        pagedResult.setPageSize(pageSize);
        System.out.println(pagedResult.getPageList());
        Map<String, Object> response = new LinkedHashMap<>();
        List<Map<String, Object>> mappingPageResultList = new ArrayList<>();
        for (Object[] eachResult : pagedResult.getPageList()) {
            Map<String, Object> mappingPageResults = new LinkedHashMap<>();
            mappingPageResults.put("videogame_id", eachResult[0]);
            mappingPageResults.put("videogame_title", eachResult[1]);
            mappingPageResultList.add(mappingPageResults);
        }
        response.put("videoGameTitleResults", mappingPageResultList);
        response.put("currentPage", pagedResult.getPage() + 1);
        response.put("totalPages", pagedResult.getPageCount());
        System.out.println(response);
        return response;
    }

    @Override
    public VideoGames findByGenre(String genre) {
        return videogameDAO.findByGenre(genre);
    }

}