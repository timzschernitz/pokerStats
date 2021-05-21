package edu.matc.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TournamentDataPreparer {

    List<String> dataToPrepare;
    ArrayList<String[]> preparedData;
    ArrayList<HashMap<String, String>> finalPreparedData;

    public TournamentDataPreparer() {}

    public TournamentDataPreparer(List<String> dataToPrepare) {
        this.dataToPrepare = dataToPrepare;
        preparedData = new ArrayList<>();
        finalPreparedData = new ArrayList<>();
    }

    public ArrayList<HashMap<String, String>> prepareData() {

        return storePreparedData(
                parseOutStringData(
                fixLabelsAndAddDelimiters(
                extractUserDataRows(dataToPrepare))));

    }

    public ArrayList<HashMap<String, String>> storePreparedData(ArrayList<String[]> dataToPrepare) {

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
