package edu.matc.service;

import edu.matc.entity.response.TournamentList;
import edu.matc.entity.response.TournamentResult;
import edu.matc.process.TournamentDataPreparer;
import edu.matc.testUtils.PropertiesLoaderInterface;
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

        apiUrl = properties.getProperty("local.api.base.url");
        apiUrl += properties.getProperty("local.api.password");
        apiUrl += properties.getProperty("api.json.indicator");
    }

    @Test
    void testLookupWisconsin() {
        apiUrl += properties.getProperty("api.tournament.results.command")
                + properties.getProperty("hard.code.in.classes");

        tournamentResult = (TournamentResult) lookup.lookupDetails(apiUrl);
        ArrayList<HashMap<String, String>> preparedData = new TournamentDataPreparer().prepareData(tournamentResult.getData());

    }
}
