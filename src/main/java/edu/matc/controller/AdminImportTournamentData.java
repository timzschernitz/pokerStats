package edu.matc.controller;

import edu.matc.entity.Game;
import edu.matc.entity.User;
import edu.matc.entity.response.TournamentResult;
import edu.matc.persistence.GenericDao;
import edu.matc.process.TournamentDataPreparer;
import edu.matc.service.LookupService;
import utils.PropertiesLoaderInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * This class takes in an admin's request to import tournament data from the Poker Mavens API
 * and processes their request based upon information they've entered. .
 *
 * @author tzschernitz
 */

@WebServlet(
        urlPatterns = {"/admin/importDataAction"}
)

public class AdminImportTournamentData extends HttpServlet implements PropertiesLoaderInterface {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Grab the information submitted by the admin identifying the tournament data to look for and import
        String league = req.getParameter("league");
        String tournamentName = req.getParameter("tournamentName");

        // Convert the tournament name into a friendly format for a URL for the API
        String urlFriendlyTournamentName;
        urlFriendlyTournamentName = tournamentName.trim();
        urlFriendlyTournamentName = urlFriendlyTournamentName.replace(" ", "%20");
        urlFriendlyTournamentName = urlFriendlyTournamentName.replace("#", "%23");

        // Convert the date entered into a friendly format use when inserting to the database
        LocalDate date = LocalDate.parse(req.getParameter("date"));

        // Instantiate properties loader to make use of webservice properties file
        Properties properties = new Properties();
        properties = loadProperties("/webServiceData.properties");
        LookupService tournamentResultLookup = new LookupService(TournamentResult.class);

        HttpSession session = req.getSession();

        //TODO Could create a class that specifically builds API URLs including converting data
        // like being done above with tournament name and date, etc...
        String tournamentResultApiUrl = properties.getProperty("local.api.base.url")
                + properties.getProperty("local.api.password")
                + properties.getProperty("api.json.indicator")
                + properties.getProperty("api.tournament.results.command")
                + "&date=" + date.toString()
                + "&name=" + urlFriendlyTournamentName;

        //TODO how to handle the exception when no result comes back as in no game found?
        TournamentResult tournamentResult = new TournamentResult();
        TournamentDataPreparer dataPreparer = new TournamentDataPreparer();
        ArrayList<HashMap<String, String>> tournamentResultData = new ArrayList<>();
        try {
            tournamentResult = (TournamentResult) tournamentResultLookup
                    .lookupDetails(tournamentResultApiUrl);
            tournamentResultData = dataPreparer.prepareData(tournamentResult.getData());
        } catch(Exception e) {
            e.printStackTrace();
            //TODO add log statement confirming failed API result
        }

        //TODO convert this to a log statement so that requests can be tracked in the logs
        System.out.println("TOURNAMENT RESULTS FETCHED::::" + tournamentResult.toString());

        User user;
        Game game;
        GenericDao<Game> gameDao = new GenericDao<>(Game.class);
        GenericDao<User> userDao = new GenericDao<>(User.class);

        try {

            for (HashMap<String, String> go : tournamentResultData) {

                user = userDao.getByPropertyEqual("userName", go.get("User")).get(0);

                // Determine if player rebought
                int rebuy = go.get("AddOn") == "Yes" ? 1500 : 0;

                game = new Game(tournamentName,
                        date,
                        1500,
                        rebuy,
                        Integer.parseInt(go.get("MoneyWon").replace("(", "").replace(")","")),
                        Integer.parseInt(go.get("Place")),
                        user);

                gameDao.insert(game);

            }

            session.setAttribute("gameDataAdded", true);
        } catch(Exception e) {
            session.setAttribute("gameDataAdded", false);
            e.printStackTrace();
            //TODO add log statement to log confirmation of failed game record insert
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/importData.jsp");
        dispatcher.forward(req, resp);
    }
}