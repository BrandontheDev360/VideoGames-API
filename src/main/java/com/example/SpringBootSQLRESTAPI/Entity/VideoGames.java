package com.example.SpringBootSQLRESTAPI.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "sp_Get_Video_Games_Titles",
                procedureName = "sp_Get_Video_Games_Titles"
        )
})
@Table(schema = "dbo", name = "videogames")
public class VideoGames {

    @Id
    @Column(name = "videogame_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "videogame_title")
    private String title;

    @Column(name = "videogame_genre")
    private String genre;
}
