package com.example.SpringBootSQLRESTAPI.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VideoGamesTitles {

    @Id
    @Column(name = "videogame_title")
    private String title;
}
