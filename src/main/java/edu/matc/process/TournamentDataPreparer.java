package edu.matc.process;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TournamentDataPreparer {

    // This word "Place" needs to be stripped out from the data
    String WORD_TO_REMOVE_FROM_USER_RESULT_DATA = "Place";

    List<String> dataToPrepare;
    ArrayList<String[]> preparedData;
    HashMap<String, String> finalPreparedData;

    public TournamentDataPreparer() {}

    public TournamentDataPreparer(List<String> dataToPrepare) {
        this.dataToPrepare = dataToPrepare;
        preparedData = new ArrayList<>();
    }

    public ArrayList<String[]> go() {
//        stripOutUnusedText(dataToPrepare, WORD_TO_REMOVE_FROM_USER_RESULT_DATA);
        parseOutStringData(stripOutUnusedText(extractUserDataRows(dataToPrepare), WORD_TO_REMOVE_FROM_USER_RESULT_DATA));





        System.out.println(preparedData.get(1)[0]);
        System.out.println(preparedData.get(1)[1]);
        System.out.println(preparedData.get(1)[2]);
        System.out.println(preparedData.get(1)[3]);
        System.out.println(preparedData.get(1)[4]);
        System.out.println(preparedData.get(1)[5]);
        System.out.println(preparedData.get(0)[0]);
        System.out.println(preparedData.get(0)[1]);
        System.out.println(preparedData.get(0)[2]);
        System.out.println(preparedData.get(0)[3]);
        System.out.println(preparedData.get(0)[4]);
        System.out.println(preparedData.get(0)[5]);
        return preparedData;
    }

//    public ArrayList<String[]> assignKeyValuePairing(ArrayList<String> dataToPrepare) {
//
//    }


    public ArrayList<String[]> parseOutStringData(ArrayList<String> dataToPrepare) {
        for (String resultDataRow : dataToPrepare) {
                preparedData.add(separateStringBySpaces(resultDataRow));
        }
        return preparedData;
    }


    public ArrayList<String> extractUserDataRows(List<String> dataToPrepare) {

        ArrayList<String> filteredData = new ArrayList<>();

        for (String resultDataRow : dataToPrepare) {
            if (identifyIfIsUserResultDataRow(resultDataRow)) {
//                preparedData.add(separateStringBySpaces(resultDataRow));
                filteredData.add(resultDataRow);
            }
        }
        return filteredData;
    }



    /**
     * This method extracts only the rows of data specific to users final tournament
     * results.
     */
    public boolean identifyIfIsUserResultDataRow(String rowToCheck) {
            if (rowToCheck.startsWith("Place")) {
                return true;
            }
        return false;
    }


    /**
     * This method splits a string into separate array values based upon spaces
     * as the delimiter.
     */
//    public String[] separateStringBySpaces(String dataToSplit) {
//        return dataToSplit.split("(\\s)");
//    }

    /**
     * Splitting by space and equal sign
     * @param dataToSplit
     * @return
     */
    public String[] separateStringBySpaces(String dataToSplit) {
        return dataToSplit.split("=|\\s");
    }

    /**
     * Removes unwanted word from string data
     * @param dataToStripFrom
     * @param textToStrip
     * @return
     */
    public ArrayList<String> stripOutUnusedText(ArrayList<String> dataToStripFrom, String textToStrip) {

        ArrayList<String> strippedData = new ArrayList<>();

        for (String lineToStripFrom : dataToStripFrom) {
            strippedData.add(StringUtils.strip(lineToStripFrom, textToStrip));
        }
        return strippedData;
    }


    public void extractUsers() {
        //extracts place finished and username
        for (String[] t : preparedData) {
            String[] tempData = t[0].split("=");

            // extracts place finished
//            System.out.println(tempData[0]);

            // extracts username
//            System.out.println(tempData[1]);

        }
    }





}
