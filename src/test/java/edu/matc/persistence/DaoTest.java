package edu.matc.persistence;

import edu.matc.testUtils.Database;

public class DaoTest {

    Database database;

    /* Calls a series of methods with SQL statements to drop test tables, create
     * new ones, and populate them with fresh data so that primary key IDs are
     * predictable for each test. Statements are run in a specific order to prevent
     * integrity errors.
     */
    void resetDaoTestData() {
        database = Database.getInstance();

        deleteTestTables();
        createTestTables();
        populateTestTables();

    }

    void deleteTestTables() {
        database.runSQL("querysForTesting/deleteGameTable.sql");
        database.runSQL("querysForTesting/deleteRoleTable.sql");
        database.runSQL("querysForTesting/deleteUserTable.sql");
    }

    void createTestTables() {
        database.runSQL("querysForTesting/createUserTable.sql");
        database.runSQL("querysForTesting/createRoleTable.sql");
        database.runSQL("querysForTesting/createGameTable.sql");
    }

    void populateTestTables() {
        database.runSQL("querysForTesting/populateUserTable.sql");
        database.runSQL("querysForTesting/populateRoleTable.sql");
        database.runSQL("querysForTesting/populateGameTable.sql");
    }
}
