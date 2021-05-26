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

/**
 * This class routes the user to the page and form they need to edit thie profile
 * information.
 *
 * @author tzschernitz
 */

@WebServlet(
        urlPatterns = {"/user/editMyProfile",
            "/admin/editMyProfile"}
)

public class EditProfileView extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        GenericDao<User> userDao = new GenericDao<>(User.class);


        // Get user game stats to display
        User user = userDao.getByPropertyEqual("userName", req.getRemoteUser()).get(0);

        // Set data to session
        session.setAttribute("user", user);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/user/editMyProfile.jsp");
        dispatcher.forward(req, resp);
    }
}