package com.example.SpringBootSQLRESTAPI.Entity;

import javax.persistence.*;

@Entity
public class Videogames {

    @Id
    @Column(name = "videogame_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String genre;


    public Videogames() {
    }

    public Videogames(int id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
