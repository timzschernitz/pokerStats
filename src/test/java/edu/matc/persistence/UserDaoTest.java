package edu.matc.persistence;

import edu.matc.entity.Game;
import edu.matc.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class UserDaoTest extends DaoTest {

    GenericDao userDao;

    @BeforeEach
    void setUp() {

        userDao = new GenericDao(User.class);

        // Delete, create, and repopulate test tables in specific order prior to each unit test
        resetDaoTestData();

    }

    /**
     * Verifies gets all users success.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = userDao.getAll();
        assertEquals(3, users.size());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {

        User newUser = new User("pokerPlayer", "michelle", "gorski", "Minnesota", 0, "MAD CITY POKER");
        newUser.setId(4);
        newUser.setPassword("4444");

        int id = userDao.insert(newUser);
        User insertedUser = (User) userDao.getById(id);

        assertEquals(newUser, insertedUser);

        GenericDao gameDao = new GenericDao(Game.class);
        List<Game> games = gameDao.getAll();
        assertEquals(3, games.size());
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {

        User userToDelete = (User) userDao.getById(2);
        userDao.delete(userToDelete);
        assertNull(userDao.getById(userToDelete.getId()));

        GenericDao gameDao = new GenericDao(Game.class);
        List <Game> foundGames = gameDao.getByPropertyEqual("user", 2);
        assertEquals(0, foundGames.size());
    }


    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String newLastName = "Randall";
        User userToUpdate = (User) userDao.getById(3);
        userToUpdate.setLastName(newLastName);
        userDao.saveOrUpdate(userToUpdate);

        User retrievedUser = (User) userDao.getById(3);
        assertEquals(userToUpdate, retrievedUser);
    }

    /**
     * Verify successful update of user
     */
    @Test
    void mergeUpdateSuccess() {
        String newLastName = "Randall";
        User userToUpdate = (User) userDao.getById(3);
        userToUpdate.setLastName(newLastName);
        userDao.mergeUpdate(userToUpdate);

        User retrievedUser = (User) userDao.getById(3);
        assertEquals(userToUpdate, retrievedUser);
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {

        User expectedUser = new User("pokerstar","jim","cunningham","East Madison",0,"MAD CITY POKER");
        expectedUser.setId(1);

//        List<User> obtainedUser = userDao.getByPropertyEqual("lastName", expectedUser.getLastName());
        List<User> obtainedUser = userDao.getByPropertyEqual("userName", expectedUser.getUserName());
        assertEquals(expectedUser, obtainedUser.get(0));

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
