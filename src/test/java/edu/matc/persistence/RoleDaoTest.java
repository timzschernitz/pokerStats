package edu.matc.persistence;

import edu.matc.entity.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class RoleDaoTest extends DaoTest {

    GenericDao roleDao;

    @BeforeEach
    void setUp() {

        roleDao = new GenericDao(Role.class);

        // Delete, create, and repopulate test tables in specific order prior to each unit test
        resetDaoTestData();

    }

    /**
     * Verifies gets all users success.
     */
    @Test
    void getAllRolesSuccess() {
        List<Role> users = roleDao.getAll();
        assertEquals(3, users.size());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {


        Role newRole = new Role("registered", "pokerPlayer", 3);
        newRole.setId(4);

        // Verify role doesn't already exist (and that past inserted test data was cleared)
        Role roleNotFound = (Role) roleDao.getById(4);
        assertNotEquals(newRole, roleNotFound);

        // Verify that the newly inserted role is present in the database
        int id = roleDao.insert(newRole);
        Role insertedRole = (Role) roleDao.getById(id);

        assertEquals(newRole, insertedRole);

    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {

        Role userRoleToDelete = (Role) roleDao.getById(2);
        roleDao.delete(userRoleToDelete);
        assertNull(roleDao.getById(userRoleToDelete.getId()));
    }


    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String newRole = "admin";
        Role userRoleToUpdate = (Role) roleDao.getById(3);
        userRoleToUpdate.setRoleName(newRole);
        roleDao.saveOrUpdate(userRoleToUpdate);

        Role retrievedRole = (Role) roleDao.getById(3);
        assertEquals(userRoleToUpdate, retrievedRole);
    }


//    /**
//     * Verify successful get by property (equal match)
//     */
//    @Test
//    void getByPropertyEqualSuccess() {
//
//        Role expectedRole = new Role("pokerstar","jim","cunningham","East Madison",0,"MAD CITY POKER");
//        expectedRole.setId(1);
//
//        List<Role> obtainedRole = roleDao.getByPropertyEqual("lastName", expectedRole.getLastName());
//        assertEquals(expectedRole, obtainedRole.get(0));
//
//    }
//
//    /**
//     * Verify successful get by multiple properties
//     */
//    @Test
//    void getByMultiplePropertyEqualSuccess() {
//
//        HashMap<String, String> propertiesToFind = new HashMap<>();
//        propertiesToFind.put("league", "MAD CITY POKER");
//        propertiesToFind.put("admin", "0");
//
//        List<Role> obtainedRoles = roleDao.getByPropertyEqual(propertiesToFind);
//        assertEquals(2, obtainedRoles.size());
//
//        HashMap<String, String> adminPropertyToFind = new HashMap<>();
//        adminPropertyToFind.put("league", "MAD CITY POKER");
//        adminPropertyToFind.put("admin", "1");
//
//        List<Role> obtainedAdminRoles = roleDao.getByPropertyEqual(adminPropertyToFind);
//        assertEquals(1, obtainedAdminRoles.size());
//
//    }

}
