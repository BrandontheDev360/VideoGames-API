package com.example.SpringBootSQLRESTAPI.Controller;

import com.example.SpringBootSQLRESTAPI.Entity.VideoGames;
import com.example.SpringBootSQLRESTAPI.Service.VideogameServiceInterface;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.containers.MSSQLServerContainer;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Rule
    public MSSQLServerContainer mssqlServerContainer = new MSSQLServerContainer().acceptLicense();

    @Autowired
    VideogameServiceInterface videogameServiceInterface;

    @Before
    public void setUp() {
        DockerImageName myImage = DockerImageName.parse("mcr.microsoft.com/mssql/server:2017-latest")
                .asCompatibleSubstituteFor("mcr.microsoft.com/mssql/server");
        mssqlServerContainer = new MSSQLServerContainer(myImage);
        mssqlServerContainer.start();

        System.out.println(mssqlServerContainer.getUsername());
        System.out.println(mssqlServerContainer.getPassword());
        System.out.println(mssqlServerContainer.getJdbcUrl());

        System.setProperty("spring.datasource.url", mssqlServerContainer.getJdbcUrl());
    }

    @Test
    void home() {

    }

    @Test
    void findVideoGamesByTitle() {
    }

    @Test
    void getAllVideoGames() {
    }

    @Test
    void addVideoGame() {
    }

    @Test
    void deleteVideoGame() {
    }

    @Test
    void findByGenre() {
        VideoGames sample = new VideoGames(1, "Test", "RPG");
        videogameServiceInterface.addVideoGame(sample);
        VideoGames result = videogameServiceInterface.findByGenre("RPG");
        assertNotNull(result);
    }
}