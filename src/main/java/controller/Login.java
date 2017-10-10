package controller;

import model.User;
import utils.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("Login");
        String password = req.getParameter("Password");

        DBWorker dbWorker = (DBWorker) getServletContext().getAttribute("dbWorker");

        User user = dbWorker.userLogin(login, password);
        if (user == null) {
            System.out.println("NO AUTHORIZED");
            //todo return to login and error message
        } else {
            System.out.println("SUCCESS AUTHORIZED");
            getServletContext().setAttribute("user", user);
            //todo go to other pages
        }
    }
}
