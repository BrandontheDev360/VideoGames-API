package com.example.SpringBootSQLRESTAPI.Service.Implementations;

import com.example.SpringBootSQLRESTAPI.Repository.UsersVideogamesDAO;
import com.example.SpringBootSQLRESTAPI.Request.InsertUsersVideogamesRequest;
import com.example.SpringBootSQLRESTAPI.Service.Interfaces.UsersVideogamesServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsersVideogamesServiceImpl implements UsersVideogamesServiceInterface {

    @Autowired
    EntityManager em;

    @Autowired
    UsersVideogamesDAO usersVideogamesDAO;

    @Override
    public Map<String, Object> insertUsersVideogame(InsertUsersVideogamesRequest request) {
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            StoredProcedureQuery storedProcedureQuery = em.createNamedStoredProcedureQuery("sp_Insert_Users_Videogame")
                    .setParameter("User_ID", request.getUserId())
                    .setParameter("Videogame_ID", request.getVideoGameId());
            String returnStatus = storedProcedureQuery.getResultList().get(0).toString();
            if (returnStatus.equalsIgnoreCase("0")) {
                response.put("statusCode", 200);
                response.put("statusMessage", "Successfully inserted User's VideoGame");
                return response;
            } else {
                response.put("statusCode", 400);
                response.put("statusMessage", "Failed to inserted User's VideoGame");
                return response;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.put("statusCode", 500);
            response.put("statusMessage", e.getMessage());
            return response;
        }
    }

    @Override
    public Map<String, Object> getAllUsersVideogamesAssociations() {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Map<String, Object>> mappingResultsList = new ArrayList<>();
        try {
            StoredProcedureQuery storedProcedureQuery = em.createNamedStoredProcedureQuery("sp_Get_All_Users_Videogames_Assocation");
            if (storedProcedureQuery.execute()) {
                List<Object[]> resultList = storedProcedureQuery.getResultList();
                for (Object[] eachResult : resultList) {
                    Map<String, Object> results = new LinkedHashMap<>();
                    results.put("User_Full_Name", eachResult[0]);
                    results.put("Users_Videogame", eachResult[1]);
                    mappingResultsList.add(results);
                }
                response.put("statusCode", 200);
                response.put("statusMessage", "Successfully retrieved All Users VideoGames Associations");
                response.put("usersVideoGamesAssociations", mappingResultsList);
                return response;
            } else {
                response.put("statusCode", 400);
                response.put("statusMessage", "Failed to retrieve All User's VideoGame Associations");
                return response;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.put("statusCode", 500);
            response.put("statusMessage", e.getMessage());
            return response;
        }
    }

    @Override
    public Map<String, Object> getAllUsersVideogamesAssociationsById(int userId) {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Map<String, Object>> mappingResultsList = new ArrayList<>();
        try {
            StoredProcedureQuery storedProcedureQuery = em.createNamedStoredProcedureQuery("sp_Get_Users_Videogames_Assocation_By_Id")
                    .setParameter("User_ID", userId);
            if (storedProcedureQuery.getResultList().listIterator().hasNext()) {
                List<Object[]> resultList = storedProcedureQuery.getResultList();
                for (Object[] eachResult : resultList) {
                    Map<String, Object> results = new LinkedHashMap<>();
                    results.put("User_Full_Name", eachResult[0]);
                    results.put("Users_Videogame", eachResult[1]);
                    mappingResultsList.add(results);
                }
                response.put("statusCode", 200);
                response.put("statusMessage", "Successfully retrieved All User's Id: " + userId + " VideoGames Associations");
                response.put("usersVideoGamesAssociations", mappingResultsList);
                return response;
            } else {
                response.put("statusCode", 204);
                response.put("statusMessage", "No Data Found");
                return response;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.put("statusCode", 500);
            response.put("statusMessage", e.getMessage());
            return response;
        }
    }
}
