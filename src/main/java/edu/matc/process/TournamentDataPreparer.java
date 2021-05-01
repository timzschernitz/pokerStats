package edu.matc.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TournamentDataPreparer {

    // This word "Place" needs to be stripped out from the data
    String WORD_TO_REMOVE_FROM_USER_RESULT_DATA = "Place";

    List<String> dataToPrepare;
    ArrayList<String[]> preparedData;
    ArrayList<HashMap<String, String>> finalPreparedData;

    public TournamentDataPreparer() {}

    public TournamentDataPreparer(List<String> dataToPrepare) {
        this.dataToPrepare = dataToPrepare;
        preparedData = new ArrayList<>();
        finalPreparedData = new ArrayList<>();
    }

    public ArrayList<String[]> go() {
//        parseOutStringData(fixLabelsAndAddDelimiters(extractUserDataRows(dataToPrepare)));
//
//        System.out.println(preparedData.get(0)[0]);
//        System.out.println(preparedData.get(0)[1]);
//        System.out.println(preparedData.get(0)[2]);
//        System.out.println(preparedData.get(0)[3]);
//        System.out.println(preparedData.get(0)[4]);
//        System.out.println(preparedData.get(0)[5]);
//        System.out.println(preparedData.get(0)[6]);
//        System.out.println(preparedData.get(0)[7]);
//        System.out.println(preparedData.get(0)[8]);
//        System.out.println(preparedData.get(0)[9]);
//        System.out.println(preparedData.get(0)[10]);

        assignKeyValuePairing(
                parseOutStringData(
                        fixLabelsAndAddDelimiters(
                                extractUserDataRows(dataToPrepare))));

        int indexTest = 0;
        for (HashMap<String, String> test : finalPreparedData) {
            indexTest++;

            for (Map.Entry<String, String> test2 : test.entrySet()) {
                System.out.println("player#" + indexTest + "==== " + test2.getKey() + " " + test2.getValue());
            }
        }


//        System.out.println(finalPreparedData.get(0).get("user"));


        return preparedData;
    }

    public ArrayList<HashMap<String, String>> assignKeyValuePairing(ArrayList<String[]> dataToPrepare) {

        HashMap<String, String> userTournamentData;

        for (String[] userData : dataToPrepare) {
            userTournamentData = new HashMap<>();
            for (int index = 0; index < userData.length-1; index+=2) {
                if (index == 2) {
                    userTournamentData.put("User", userData[index]);
                    index-=1;
                } else {
                    userTournamentData.put(userData[index], userData[index+1]);
                }
            }
            finalPreparedData.add(userTournamentData);
        }
        this.finalPreparedData = finalPreparedData;
        return finalPreparedData;
    }


    public ArrayList<String[]> parseOutStringData(ArrayList<String> dataToPrepare) {
        for (String resultDataRow : dataToPrepare) {
                preparedData.add(separateStringBySpaces(resultDataRow));
        }
        return preparedData;
    }

    /**
     * This method filters the Tournament Result data and extracts just the rows
     * relevant to individual user results.
     *
     * @param dataToPrepare
     * @return
     */
    public ArrayList<String> extractUserDataRows(List<String> dataToPrepare) {
        ArrayList<String> filteredData = new ArrayList<>();
        for (String resultDataRow : dataToPrepare) {
            if (resultDataRow.startsWith("Place")) {
                filteredData.add(resultDataRow);
            }
        }
        return filteredData;
    }

    /**
     * Splits a string by equals signs (=), spaces ( ), and colons (:).
     * @param dataToSplit
     * @return
     */
    public String[] separateStringBySpaces(String dataToSplit) {
        return dataToSplit.split("=|\\s|:");
    }

    /**
     * This method fixes the user data string rows by adding a label for Money Won
     * data and also adds colons where there isn't one separating a label from
     * a corresponding value.
     *
     * @param dataToFix
     * @return
     */
    public ArrayList<String> fixLabelsAndAddDelimiters(ArrayList<String> dataToFix) {
        ArrayList<String> strippedData = new ArrayList<>();
        for (String lineToStripFrom : dataToFix) {
            strippedData.add(lineToStripFrom.replace("Place", "Place:").replace("(", "MoneyWon:("));
        }
        return strippedData;
    }

}
