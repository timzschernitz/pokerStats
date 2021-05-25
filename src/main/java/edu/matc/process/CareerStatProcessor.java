package edu.matc.process;

import edu.matc.entity.Game;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class receives indiviual game/tournament data and processes it by determining
 * averages and totals from the chunk of data received.
 *
 */
public class CareerStatProcessor {

    List<Game> gameDataToProcess;
    HashMap<String, Integer> compiledGameData = new HashMap<>();

    public CareerStatProcessor() {}



    public HashMap<String, Integer> processStats(List<Game> gameDataToProcess) {

        int totalGamesPlayed = gameDataToProcess.size();
        int totalBuyInPaid = 0;
        int timesRebought = 0;
        int totalRebuyPaid = 0;
        int grandTotalPaid = 0;
        int grandTotalWon = 0;
        int averagePlacement = 0;
        int tournamentsWon = 0;

        for (Game game : gameDataToProcess) {

            // Add to total buy-in paid
            totalBuyInPaid += game.getBuyInPaid();

            // Determine if rebought back into game to count towards total rebuys
            if (game.getRebuyPaid() > 0) timesRebought += 1;

            // Calculate total money won
            grandTotalWon += game.getMoneyWon();

            // Add up each placement and then after loop completes calculate average placement
            averagePlacement += game.getPositionFinished();

            // Increment win counter if position finished is 1
            if (game.getPositionFinished() == 1) tournamentsWon++;

        }

        averagePlacement = averagePlacement / gameDataToProcess.size();
        grandTotalPaid = totalBuyInPaid + totalRebuyPaid;
        totalRebuyPaid = timesRebought * 20;

        compiledGameData.put("totalGamesPlayed", totalGamesPlayed);
        compiledGameData.put("totalBuyInPaid", totalBuyInPaid);
        compiledGameData.put("timesRebought", timesRebought);
        compiledGameData.put("totalRebuyPaid", totalRebuyPaid);
        compiledGameData.put("grandTotalPaid", grandTotalPaid);
        compiledGameData.put("grandTotalWon", grandTotalWon);
        compiledGameData.put("averagePlacement", averagePlacement);
        compiledGameData.put("tournamentsWon", tournamentsWon);

        return compiledGameData;

    }

}
