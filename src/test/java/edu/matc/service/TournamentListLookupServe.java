package edu.matc.service;

import edu.matc.entity.response.TournamentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TournamentListLookupServe {

    String apiUrl;
    TournamentList tournamentList;
    LookupService lookup;

    @BeforeEach
    void setUp() {
        lookup = new LookupService(TournamentList.class);
        apiUrl = "http://localhost:8087/api?password=scottPilgrimVS7EvilXs&command=TournamentsResults&JSON=YES";
    }

    @Test
    void testLookupWisconsin() {

        tournamentList = (TournamentList) lookup.lookupDetails(apiUrl);

        System.out.println(tournamentList);

//        assertEquals("Sun Prairie", locationDetail.getPlaceName());
//        assertEquals("Wisconsin", locationDetail.getAdminName1());
//        assertEquals("WI", locationDetail.getAdminCode1());
//
//        assertNotEquals("Madison", locationDetail.getPlaceName());
//        assertNotEquals("Illinois", locationDetail.getAdminName1());
//        assertNotEquals("MN", locationDetail.getAdminCode1());

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
