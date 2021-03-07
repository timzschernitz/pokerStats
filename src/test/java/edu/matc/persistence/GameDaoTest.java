package edu.matc.persistence;

import edu.matc.entity.Game;
import edu.matc.entity.User;
import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameDaoTest {

    GenericDao genericDao;

    GameDao gameDao;
    Database database;

    @BeforeEach
    void setup() {

        genericDao = new GenericDao(Game.class);

        gameDao = new GameDao();

        database = Database.getInstance();
        database.runSQL("cleandb.sql");
        database.runSQL("cleandb3.sql");
        database.runSQL("cleandb4.sql");
        database.runSQL("cleandb2.sql");
    }

    @Test
    void getAllSuccess() {
        List<Game> games = genericDao.getAll();
        assertEquals(3, games.size());

    }

    @Test
    void getById() {
        LocalDate date = LocalDate.parse("2021-02-21");

        Game expectedGame = new Game(date, 20, 0, 60, 1, null);
        expectedGame.setId(1);

        Game foundGame = (Game) genericDao.getById(1);

        assertEquals(expectedGame, foundGame);
    }


    @Test
    void getByUser() {

        User user = new User("bigspender21", "sal","morrison", "Tomah", 1, "MAD CITY POKER");

        List<Game> games = gameDao.getGamesByUserName(user);
    }




}