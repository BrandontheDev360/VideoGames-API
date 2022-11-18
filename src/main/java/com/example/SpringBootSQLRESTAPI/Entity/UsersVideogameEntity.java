package com.example.SpringBootSQLRESTAPI.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "sp_Insert_Users_Videogame",
                procedureName = "sp_Insert_Users_Videogame",
                parameters = {
                        @StoredProcedureParameter(name = "User_ID", type = Integer.class),
                        @StoredProcedureParameter(name = "Videogame_ID", type = Integer.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "sp_Get_All_Users_Videogames_Assocation",
                procedureName = "sp_Get_All_Users_Videogames_Assocation"
        )
})
@Table(schema = "dbo", name = "Users_VideoGames")
public class UsersVideogameEntity {

    @Id
    @Column(name = "Users_VideoGames_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "User_Id", nullable = false)
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Videogame_Id", nullable = false)
    private VideoGames videogameId;

}