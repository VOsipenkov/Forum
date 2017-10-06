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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       DBWorker dbWorker = (DBWorker)getServletContext().getAttribute("dbWorker");
       dbWorker.addUser(new User());
    }
}
