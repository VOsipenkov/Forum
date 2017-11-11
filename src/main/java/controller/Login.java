package controller;

import model.User;
import utils.DBWorker;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="loginController", urlPatterns = {"/loginController"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("Login");
        String password = req.getParameter("Password");

        DBWorker dbWorker = (DBWorker) getServletContext().getAttribute("dbWorker");

        User user = dbWorker.userLogin(login, password);
        if (user == null) {
            System.out.println("NO AUTHORIZED");
            req.setAttribute("errorMessage", "There is no such pair login\\password");
            req.getRequestDispatcher("/loginView").forward(req, resp);
        } else {
            System.out.println("SUCCESS AUTHORIZED");
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/listThemes").forward(req, resp);
        }
    }
}
