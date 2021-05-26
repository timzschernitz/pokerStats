package edu.matc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This class routes the user to the home page upon a successful login.
 * @author tzschernitz
 */

@WebServlet(
        urlPatterns = {"/user/login"}
)

public class LoginSuccess extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getUserPrincipal().getName();
        HttpSession session = req.getSession();
        session.setAttribute("username", username);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/user/home.jsp");
        dispatcher.forward(req, resp);
    }
}