package edu.matc.persistence;

import edu.matc.entity.Game;
import edu.matc.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameDaoTest extends DaoTest {

    GenericDao gameDao;
    GenericDao userDao;

    @BeforeEach
    void setup() {

        gameDao = new GenericDao(Game.class);
        userDao = new GenericDao(User.class);

        // Delete, create, and repopulate test tables in specific order prior to each unit test
        resetDaoTestData();

    }

    @Test
    void getAllSuccess() {
        List<Game> games = gameDao.getAll();
        assertEquals(3, games.size());

    }


    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        Game newGame = new Game(
                LocalDate.of(2021, 05, 22),
                15,
                0,
                15,
                1,
                (User) userDao.getById(3));

        int id = gameDao.insert(newGame);
        Game insertedGame = (Game) gameDao.getById(id);

        assertEquals(newGame, insertedGame);

    }






    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {

        Game gameToDelete = (Game) gameDao.getById(3);
        gameDao.delete(gameToDelete);
        assertNull(gameDao.getById(gameToDelete.getId()));

        assertNotEquals(3, gameDao.getAll().size());
        assertEquals(2, gameDao.getAll().size());

    }


    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        LocalDate updatedDatePlayed = LocalDate.of(2021,05,22);
        Game gameToUpdate = (Game) gameDao.getById(1);
        gameToUpdate.setDatePlayed(updatedDatePlayed);
        gameDao.saveOrUpdate(gameToUpdate);

        Game retrievedGame = (Game) gameDao.getById(1);
        assertEquals(gameToUpdate, retrievedGame);
    }


    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {

        Game expectedGame = new Game(
                LocalDate.of(2021, 02, 21),
                20,
                0,
                60,
                1,
                (User) userDao.getById(1));
        expectedGame.setId(1);

        List <Game> obtainedGame = gameDao.getByPropertyEqual("user", expectedGame.getUser().getId());
        assertEquals(expectedGame, obtainedGame.get(0));

    }

    /**
     * Verify successful get by multiple properties
     */
    @Test
    void getByMultiplePropertyEqualSuccess() {

        HashMap<String, String> propertiesToFind = new HashMap<>();
        propertiesToFind.put("league", "MAD CITY POKER");
        propertiesToFind.put("admin", "0");

        List<User> obtainedUsers = userDao.getByPropertyEqual(propertiesToFind);
        assertEquals(2, obtainedUsers.size());

        HashMap<String, String> adminPropertyToFind = new HashMap<>();
        adminPropertyToFind.put("league", "MAD CITY POKER");
        adminPropertyToFind.put("admin", "1");

        List<User> obtainedAdminUsers = userDao.getByPropertyEqual(adminPropertyToFind);
        assertEquals(1, obtainedAdminUsers.size());

    }

}
