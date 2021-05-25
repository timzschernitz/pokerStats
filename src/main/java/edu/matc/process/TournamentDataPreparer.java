package edu.matc.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * The type Tournament data preparer.
 */
public class TournamentDataPreparer {

    /**
     * The Data to prepare.
     */
    List<String> dataToPrepare;

    /**
     * Instantiates a new Tournament data preparer.
     */
    public TournamentDataPreparer() {}

    /**
     * Instantiates a new Tournament data preparer.
     *
     * @param dataToPrepare the data to prepare
     */
    public TournamentDataPreparer(List<String> dataToPrepare) {
        this.dataToPrepare = dataToPrepare;
    }

    /**
     * Prepare data array list.
     *
     * @return the array list
     */
    public ArrayList<HashMap<String, String>> prepareData() {

        return storePreparedData(
                parseOutStringData(
                fixLabelsAndAddDelimiters(
                extractUserDataRows(dataToPrepare))));

    }

    /**
     * Store prepared data array list.
     *
     * @param dataToPrepare the data to prepare
     * @return the array list
     */
    public ArrayList<HashMap<String, String>> storePreparedData(ArrayList<String[]> dataToPrepare) {

        HashMap<String, String> userTournamentData;
        ArrayList<HashMap<String, String>> finalPreparedData = new ArrayList<>();

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


    /**
     * Parse out string data array list.
     *
     * @param dataToPrepare the data to prepare
     * @return the array list
     */
    public ArrayList<String[]> parseOutStringData(ArrayList<String> dataToPrepare) {

        ArrayList<String[]> preparedData = new ArrayList<>();

        for (String resultDataRow : dataToPrepare) {
                preparedData.add(resultDataRow.split("=|\\s|:"));
        }
        return preparedData;
    }

    /**
     * This method filters the Tournament Result data and extracts just the rows
     * relevant to individual user results.
     *
     * @param dataToPrepare the data to prepare
     * @return array list
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
     * This method fixes the user data string rows by adding a label for Money Won
     * data and also adds colons where there aren't one separating a label from
     * a corresponding value.
     *
     * @param dataToFix the data to fix
     * @return array list
     */
    public ArrayList<String> fixLabelsAndAddDelimiters(ArrayList<String> dataToFix) {
        ArrayList<String> strippedData = new ArrayList<>();
        for (String lineToStripFrom : dataToFix) {
            strippedData.add(lineToStripFrom.replace("Place", "Place:").replace("(", "MoneyWon:("));
        }
        return strippedData;
    }

}
