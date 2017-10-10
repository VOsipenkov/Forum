package controller;

import model.User;
import utils.DBWorker;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBWorker dbWorker = (DBWorker)getServletContext().getAttribute("dbWorker");

        User user = new User();
        user.setPassword(req.getParameter("Password"));
        user.setUserLogin(req.getParameter("Login"));
        user.setRole(2);
        user.setBanToDate(null);
        user.setEmail(req.getParameter("Email"));

        dbWorker.addUser(user);
    }
}
