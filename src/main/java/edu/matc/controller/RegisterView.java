package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * A simple servlet to welcome the user.
 * @author tzschernitz
 */

@WebServlet(
        urlPatterns = {"/register"}
)

public class RegisterView extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


//        GenericDao userDao = new GenericDao(User.class);

        /* Determine if sufficient search criteria entered for specific search or to
        / return all results from database.
         */
//        if (req.getParameter("searchType") != null) {
//            if (req.getParameter("searchType").equals("id")) {
//                List<User> user = new ArrayList<>();
//                user.add((User) userDao.getById(parseInt(req.getParameter("searchTerm"))));
//                req.setAttribute("users", user);
//            } else if (req.getParameter("searchType").equals("last_name")) {
//                req.setAttribute("users", userDao.getByPropertyLike("lastName", req.getParameter("searchTerm")));
//            } else if (req.getParameter("searchType").equals("first_name")) {
//                req.setAttribute("users", userDao.getByPropertyLike("firstName", req.getParameter("searchTerm")));
//            }
//        } else {
//            req.setAttribute("users", userDao.getAll());
//        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/register.jsp");
        dispatcher.forward(req, resp);
    }
}