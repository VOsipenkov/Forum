package controller;

import model.User;
import utils.DBWorker;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TestConnection extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = ((DBWorker) getServletContext().getAttribute("dbWorker")).getAllUsers();

        for (User user : userList){
            System.out.println(user);
        }
    }
}
