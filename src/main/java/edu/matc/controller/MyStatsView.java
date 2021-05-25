package edu.matc.controller;

import edu.matc.entity.Game;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import edu.matc.process.CareerStatProcessor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * A simple servlet to welcome the user.
 * @author tzschernitz
 */

@WebServlet(
        urlPatterns = {"/user/getMyStats"}
)

public class MyStatsView extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        GenericDao<Game> gameDao = new GenericDao<>(Game.class);
        GenericDao<User> userDao = new GenericDao<>(User.class);
        CareerStatProcessor careerStatProcessor = new CareerStatProcessor();

        // Get user game stats to display
        List<User> user = userDao.getByPropertyEqual("userName", req.getRemoteUser());
        List<Game> userGameData = gameDao.getByPropertyEqual("user", user.get(0));

        HashMap<String, Integer> careerCompiledStats = careerStatProcessor.processStats(userGameData);

        // Set data to session
        session.setAttribute("games", userGameData);
        session.setAttribute("careerStats", careerCompiledStats);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/user/viewMyStats.jsp");
        dispatcher.forward(req, resp);
    }
}