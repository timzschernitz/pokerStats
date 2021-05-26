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
import java.util.Map;
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
//        apiUrl += properties.getProperty();
//        apiUrl += properties.getProperty();

        //apiUrl = "http://localhost:8087/api?password=scottPilgrimVS7EvilXs&command=TournamentsResults&date=2021-04-17&name=Tournament%20%2306&JSON=YES";

    }

    @Test
    void testLookupWisconsin() {
        apiUrl += properties.getProperty("api.tournament.results.command")
                + properties.getProperty("hard.code.in.classes");

        tournamentResult = (TournamentResult) lookup.lookupDetails(apiUrl);
        ArrayList<HashMap<String, String>> preparedData = new TournamentDataPreparer().prepareData(tournamentResult.getData());




        for (HashMap<String, String> test : preparedData) {

            System.out.println(test.get("AddOn"));

//            for (String bloop : test.keySet()) {
//                System.out.println(bloop);
//            }

//            for (Map.Entry<String, String> test2 : test.entrySet()) {
//                System.out.println(
//                        "====" + "player#"
//                                + indexTest
//                                + "==== "
//                                + test2.getKey()
//                                + " "
//                                + test2.getValue()
//                );
//            }
        }

    }
}
