package com.example.SpringBootSQLRESTAPI.Repository;

import com.example.SpringBootSQLRESTAPI.Entity.VideoGamesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideogameDAO  extends PagingAndSortingRepository<VideoGamesEntity, Integer> {
    Page<VideoGamesEntity> findByTitle(String title, Pageable page);

    VideoGamesEntity findByGenre(String genre);

    @Query(value = "SELECT * FROM [dbo].[videogames] WHERE videogame_title LIKE ?1%", nativeQuery = true)
    Page<VideoGamesEntity> findByTitleLikeIgnoreCase(String title, Pageable pageable);

    @Query(value = "SELECT * FROM [dbo].[videogames] WHERE videogame_genre LIKE ?1%", nativeQuery = true)
    Page<VideoGamesEntity> findByGenreLikeIgnoreCase(String genre, Pageable page);

//    @Procedure(procedureName = "sp_Get_Video_Games_Titles")
    @Query(value = "SELECT DISTINCT videogame_title \n" +
            "\tFROM [dbo].[videogames]", nativeQuery = true)
    List<Object> getVideoGamesTitles();

}
