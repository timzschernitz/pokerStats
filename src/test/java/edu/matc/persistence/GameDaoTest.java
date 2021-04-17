package edu.matc.persistence;

import edu.matc.entity.Game;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameDaoTest {

    GenericDao gameDao;
    Database database;

    @BeforeEach
    void setup() {

        gameDao = new GenericDao(Game.class);

        database = Database.getInstance();

        /* Series of SQL statements to drop test tables, create new ones,
         * and populate them with fresh data so that primary key IDs are predictable
         * for each test. Statements are run in a specific order to prevent integrity
         * errors.
         */
        database.runSQL("querysForTesting/deleteGameTable.sql");
        database.runSQL("querysForTesting/deleteUserTable.sql");
        database.runSQL("querysForTesting/createUserTable.sql");
        database.runSQL("querysForTesting/createGameTable.sql");
        database.runSQL("querysForTesting/populateUserTable.sql");
        database.runSQL("querysForTesting/populateGameTable.sql");
    }

    @Test
    void getAllSuccess() {
        List<Game> games = gameDao.getAll();
        assertEquals(3, games.size());

    }
//
//    @Test
//    void getById() {
//        LocalDate date = LocalDate.parse("2021-02-21");
//
//        Game expectedGame = new Game(date, 20, 0, 60, 1, null);
//        expectedGame.setId(1);
//
//        Game foundGame = (Game) genericDao.getById(1);
//
//        assertEquals(expectedGame, foundGame);
//    }
//
//
//    @Test
//    void getByUser() {
//
//        User user = new User("bigspender21", "sal","morrison", "Tomah", 1, "MAD CITY POKER");
//
////        List<Game> games = gameDao.getGamesByUserName(user);
//    }




}
