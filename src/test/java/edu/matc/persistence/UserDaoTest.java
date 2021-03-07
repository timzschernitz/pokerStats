package edu.matc.persistence;

import edu.matc.testUtils.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class UserDaoTest {

    GenericDao genericDao;

    Database database;

    @BeforeEach
    void setUp() {
        database = Database.getInstance();



    }
}
