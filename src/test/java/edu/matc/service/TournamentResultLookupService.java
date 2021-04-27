package edu.matc.service;

import edu.matc.entity.response.TournamentList;
import edu.matc.entity.response.TournamentResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TournamentResultLookupService {

    String apiUrl;
    TournamentResult tournamentResult;
    LookupService lookup;

    @BeforeEach
    void setUp() {
        lookup = new LookupService(TournamentResult.class);
        apiUrl = "http://localhost:8087/api?password=scottPilgrimVS7EvilXs&command=TournamentsResults&date=2021-04-17&name=Tournament%20%2306&JSON=YES";
    }

    @Test
    void testLookupWisconsin() {

        tournamentResult = (TournamentResult) lookup.lookupDetails(apiUrl);

        System.out.println(tournamentResult);

        List<String> testData = tournamentResult.getData();

        String[] splitString = null;
        ArrayList<String[]> split1 = new ArrayList();

        for (String s : testData) {
            if (s.startsWith("Place")) {

//                splitString = s.trim().split("(?=\\s)");
                split1.add(s.split("(\\s)"));

            }


        }

        for (String[] t : split1) {
            String[] tempData = t[0].split("=");
            System.out.println(tempData[0]);
            System.out.println(tempData[1]);
        }


        for (String[] g : split1) {
            System.out.println(g[1]);
            String[] tempData2 = g[1].split("(?=\\()");
            System.out.println(tempData2[0]);
        }

        for (String[] g : split1) {
            System.out.println(g[2]);
//            String[] tempData2 = g[2].split("()");
//            System.out.println(tempData2[0]);
        }


//        System.out.println(split1.get(1)[0]);
//        System.out.println(split1.get(1)[1]);
//        System.out.println(split1.get(1)[2]);

//        int positionFinished;
//        String playerUserName;
//        int rebuys;
//
//        for (String[] g : split1) {
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
