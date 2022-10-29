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
public class Videogames {

    @Id
    @Column(name = "videogame_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "videogame_title")
    private String title;

    @Column(name = "videogame_genre")
    private String genre;
}
