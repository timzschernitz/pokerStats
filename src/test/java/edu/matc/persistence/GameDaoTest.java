package edu.matc.persistence;

import edu.matc.entity.Game;
import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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
        database.runSQL("deleteGameTable.sql");
        database.runSQL("deleteUserTable.sql");
        database.runSQL("createUserTable.sql");
        database.runSQL("createGameTable.sql");
        database.runSQL("populateUserTable.sql");
        database.runSQL("populateGameTable.sql");
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
