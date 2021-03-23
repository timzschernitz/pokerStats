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
        urlPatterns = {"/user/profileView"}
)

public class ViewMyProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        GenericDao userDao = new GenericDao(User.class);


        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        List<User> userProfileData = userDao.getByPropertyEqual("userName", username);

        /* Determine if sufficient search criteria entered for specific search or to
        / return all results from database.
         */
        session.setAttribute("user", userProfileData.get(0));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/user/profile.jsp");
        dispatcher.forward(req, resp);
    }
}