package edu.matc.controller;

import edu.matc.entity.Role;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This classes processes a users registration request.
 * @author tzschernitz
 */

@WebServlet(
        urlPatterns = {"/registerUser"}
)

public class RegisterAction extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //TODO need to add backup for instances where the username has already been registered
        // or there was an error and need to persist the input fields. Add the parameter values
        // to a session variable with page scope that's immediately cleared upon page load.
        // Use the variable to fill in fields with those values.

        //TODO need to also add a check to see if the user entered the correct league name.
        // Also how to ensure that the user entered the right user name?  same as the one they use in PokerMavens...

        User user = new User(req.getParameter("userName"),
                req.getParameter("firstName"),
                req.getParameter("lastName"),
                req.getParameter("location"),
                req.getParameter("admin").equals("yes") ? 1 : 0,
                req.getParameter("league"));
        user.setPassword(req.getParameter("password"));

        //TODO need to add a try catch block here for when the registration fails rather than allowing an exception
        GenericDao<User> userDao = new GenericDao<>(User.class);
        Integer insertedUserId = userDao.insert(user);
        //TODO add a Log statement here to log confirmation of registration

        Role role;
        GenericDao<Role> roleDao = new GenericDao<>(Role.class);
        if (null != insertedUserId) {
            role = new Role(user.getAdmin() == 1 ? "admin" : "registered",
                    user.getUserName(),
                    insertedUserId);
            roleDao.insert(role);
        }

        String url = "index";
        resp.sendRedirect(url);

    }
}
