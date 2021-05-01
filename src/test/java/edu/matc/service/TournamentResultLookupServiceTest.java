package edu.matc.service;

import edu.matc.entity.response.TournamentList;
import edu.matc.entity.response.TournamentResult;
import edu.matc.process.TournamentDataPreparer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TournamentResultLookupServiceTest {

    String apiUrl;
    TournamentResult tournamentResult;
    LookupService lookup;

    TournamentDataPreparer tournamentDataPreparer;

    @BeforeEach
    void setUp() {
        lookup = new LookupService(TournamentResult.class);
        apiUrl = "http://localhost:8087/api?password=scottPilgrimVS7EvilXs&command=TournamentsResults&date=2021-04-17&name=Tournament%20%2306&JSON=YES";

    }

    @Test
    void testLookupWisconsin() {

        tournamentResult = (TournamentResult) lookup.lookupDetails(apiUrl);

//        System.out.println(tournamentResult);

        ArrayList<String[]> preparedData = new TournamentDataPreparer(tournamentResult.getData()).go();



//        List<String> dataToPrepare = tournamentResult.getData();
//
//        ArrayList<String[]> preparedData = new ArrayList();
//
//
//        /* Is used specifically for processing and splitting data within the Data
//         * array within the TournamentResult class and more specifically only targets
//         * the lines of data that contain individual user end game stats by parsing
//         * out the individual data sets within the single string.
//         */
//        for (String s : dataToPrepare) {
//            if (s.startsWith("Place")) {
//
//                preparedData.add(s.split("(\\s)"));
//
//            }
//
//        }
//
//        // extracts place finished and username
//        for (String[] t : preparedData) {
//            String[] tempData = t[0].split("=");
//
//            // extracts place finished
////            System.out.println(tempData[0]);
//
//            // extracts username
////            System.out.println(tempData[1]);
//
//        }
//
//        // extracts money won data
//        for (String[] g : preparedData) {
//            String[] tempData2 = g[1].split("(?=\\()");
////            System.out.println(tempData2[0]);
//        }
//
//        // extracts rebuy data
//        for (String[] g : preparedData) {
////            System.out.println(g[2]);
////            String[] tempData2 = g[2].split("()");
////            System.out.println(tempData2[0]);
//        }


//        System.out.println(preparedData.get(1)[0]);
//        System.out.println(preparedData.get(1)[1]);
//        System.out.println(preparedData.get(1)[2]);

//        int positionFinished;
//        String playerUserName;
//        int rebuys;
//
//        for (String[] g : preparedData) {
//            for (String s : g) {
//                s = s.trim();
//                System.out.println(s);
//                if (s.startsWith("Place")) {
//
//                    System.out.println(s.split("Place"));
//                } else if (s.startsWith("(")) {
//                    System.out.println(s);
//                } else if (s.startsWith("Rebuys")) {
//                    System.out.println(s);
//                } else if (s.startsWith("KO")) {
//                    System.out.println(s);
//                }
//            }
//        }


    }

//    @Test
//    void testLookupMinnesota() {
//
//        apiUrl += "&postalcode=55401";
//
//        postalCodeSearchResults = (PostalCode) lookup.lookupDetails(apiUrl);
//        PostalCodesItem locationDetail = postalCodeSearchResults.getPostalCodes().get(0);
//
//        assertEquals("Minneapolis", locationDetail.getPlaceName());
//        assertEquals("Minnesota", locationDetail.getAdminName1());
//        assertEquals("MN", locationDetail.getAdminCode1());
//
//        assertNotEquals("Chicago", locationDetail.getPlaceName());
//        assertNotEquals("South Dakota", locationDetail.getAdminName1());
//        assertNotEquals("CA", locationDetail.getAdminCode1());
//
//    }

}
