package controller;

import model.User;
import utils.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static utils.Constants.DB_WORKER;
import static utils.UrlConstants.LOGIN_VIEW_URL;
import static utils.UrlConstants.THEMES_LIST_CONTROLLER_URL;

@WebServlet(name = "loginController", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("Login");
        String password = req.getParameter("Password");
        DBWorker dbWorker = (DBWorker) getServletContext().getAttribute(DB_WORKER);

        req.getSession().setAttribute("errorMessage", null);
        User user = dbWorker.userLogin(login, password);

        if (user == null) {
            System.out.println("NO AUTHORIZED");
            req.setAttribute("errorMessage", "There is no such pair login\\password");
            req.getRequestDispatcher(LOGIN_VIEW_URL).forward(req, resp);
        } else {
            System.out.println("SUCCESS AUTHORIZED");
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher(THEMES_LIST_CONTROLLER_URL).forward(req, resp);
        }
    }
}
