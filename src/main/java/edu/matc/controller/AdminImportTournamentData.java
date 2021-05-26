package edu.matc.controller;

import edu.matc.entity.Game;
import edu.matc.entity.User;
import edu.matc.entity.response.TournamentResult;
import edu.matc.persistence.GenericDao;
import edu.matc.process.TournamentDataPreparer;
import edu.matc.service.LookupService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    User user;
    Game game;
    GenericDao<Game> gameDao;
    GenericDao<User> userDao;

    String league;
    String tournamentName;
    String urlFriendlyTournamentName;
    String tournamentResultApiUrl;

    Properties properties;

    LookupService tournamentResultLookup;

    TournamentResult tournamentResult;
    TournamentDataPreparer dataPreparer;
    ArrayList<HashMap<String, String>> tournamentResultData;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Grab the information submitted by the admin identifying the tournament data to look for and import
        league = req.getParameter("league");
        tournamentName = req.getParameter("tournamentName");

        // Convert the tournament name into a friendly format for a URL for the API

        urlFriendlyTournamentName = tournamentName.trim();
        urlFriendlyTournamentName = urlFriendlyTournamentName.replace(" ", "%20");
        urlFriendlyTournamentName = urlFriendlyTournamentName.replace("#", "%23");

        // Convert the date entered into a friendly format use when inserting to the database
        LocalDate date = LocalDate.parse(req.getParameter("date"));

        // Instantiate properties loader to make use of webservice properties file
        properties = new Properties();
        properties = loadProperties("/webServiceData.properties");
        tournamentResultLookup = new LookupService(TournamentResult.class);

        HttpSession session = req.getSession();

        //TODO Could create a class that specifically builds API URLs including converting data
        // like being done above with tournament name and date, etc...
        tournamentResultApiUrl = properties.getProperty("local.api.base.url")
                + properties.getProperty("local.api.password")
                + properties.getProperty("api.json.indicator")
                + properties.getProperty("api.tournament.results.command")
                + "&date=" + date.toString()
                + "&name=" + urlFriendlyTournamentName;

        //TODO how to handle the exception when no result comes back as in no game found?
        tournamentResult = new TournamentResult();
        dataPreparer = new TournamentDataPreparer();
        tournamentResultData = new ArrayList<>();
        try {
            tournamentResult = (TournamentResult) tournamentResultLookup
                    .lookupDetails(tournamentResultApiUrl);
            tournamentResultData = dataPreparer.prepareData(tournamentResult.getData());
            logger.info("Fetched tournament results from API: " + tournamentResult.toString());
        } catch(Exception e) {
            e.printStackTrace();
            logger.error("API did not return data", e);
        }

        gameDao = new GenericDao<>(Game.class);
        userDao = new GenericDao<>(User.class);
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
            logger.info("Game info successfully inserted to DB.");
        } catch(Exception e) {
            session.setAttribute("gameDataAdded", false);
            e.printStackTrace();
            logger.info("Game insert failed...", e);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/importData.jsp");
        dispatcher.forward(req, resp);
    }
}