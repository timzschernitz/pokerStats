package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * A simple servlet to welcome the user.
 * @author tzschernitz
 */

@WebServlet(
        urlPatterns = {"/loginFailed"}
)

public class LoginFailure extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String loginPageUrl = "/login.jsp";
        String loginFailureMessage = "Sorry, we were unable to verify your login credentials. <br />" +
                "Either your username, password, or both were incorrect. Please try again. <br /><br />" +
                "If you have not yet created an account, <a href='../register'>register here</a> " +
                "to make one and join or create a league.";

        HttpSession session = req.getSession();
        session.setAttribute("loginError", loginFailureMessage);

        RequestDispatcher dispatcher = req.getRequestDispatcher(loginPageUrl);
        dispatcher.forward(req, resp);
    }
}