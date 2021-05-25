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
        urlPatterns = {"/user/editProfileAction"}
)

public class EditProfileAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        GenericDao<User> userDao = new GenericDao<>(User.class);

        // Get user to update
        User user = userDao.getByPropertyEqual("userName", req.getRemoteUser()).get(0);

        //TODO need to figure out best way to handle updating a username...
//        user.setUserName(req.getParameter("userName"));

        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setLocation(req.getParameter("location"));
        user.setLeague(req.getParameter("league"));
        if (req.getParameter("password").length() > 0) user.setPassword(req.getParameter("password"));

        userDao.mergeUpdate(user);

        String url = "profileView";
        resp.sendRedirect(url);
    }
}