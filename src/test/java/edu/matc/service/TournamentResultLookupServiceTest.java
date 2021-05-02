package edu.matc.service;

import edu.matc.entity.response.TournamentList;
import edu.matc.entity.response.TournamentResult;
import edu.matc.process.TournamentDataPreparer;
import edu.matc.testUtils.PropertiesLoaderInterface;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class TournamentResultLookupServiceTest implements PropertiesLoaderInterface {

    String apiUrl;
    TournamentResult tournamentResult;
    TournamentList tournamentList;
    LookupService lookup;
    Properties properties;

    TournamentResultLookupServiceTest() {
        properties = loadProperties("/webServiceData.properties");
    }

    @BeforeEach
    void setUp() {
        lookup = new LookupService(TournamentResult.class);

        apiUrl = properties.getProperty("local.api.request.path");


        //apiUrl = "http://localhost:8087/api?password=scottPilgrimVS7EvilXs&command=TournamentsResults&date=2021-04-17&name=Tournament%20%2306&JSON=YES";

    }

    @Test
    void testLookupWisconsin() {
        apiUrl += properties.getProperty("api.tournament.results.command")
                + properties.getProperty("hard.code.in.classes");

        tournamentResult = (TournamentResult) lookup.lookupDetails(apiUrl);
        ArrayList<HashMap<String, String>> preparedData = new TournamentDataPreparer(tournamentResult.getData()).prepareData();

    }
}
