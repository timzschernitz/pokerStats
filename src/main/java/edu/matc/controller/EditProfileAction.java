package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class processes a users request to make updates to their profile information.
 *
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

        //TODO need to figure out best way to handle updating a username and password...
//        user.setUserName(req.getParameter("userName"));
//        if (req.getParameter("password").length() > 0) user.setPassword(req.getParameter("password"));

        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setLocation(req.getParameter("location"));
        user.setLeague(req.getParameter("league"));

        userDao.mergeUpdate(user);

        String url = "profileView";
        resp.sendRedirect(url);
    }
}