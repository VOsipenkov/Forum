package controller;

import utils.Constants;
import utils.DBWorker;
import utils.UrlConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addNewTheme", urlPatterns = "/themes/create")
public class AddNewThemeController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBWorker dbWorker = (DBWorker) req.getServletContext().getAttribute(Constants.DB_WORKER);
        String themeName = (String) req.getParameter("addTheme");
        dbWorker.addTheme(themeName);

        req.getRequestDispatcher(UrlConstants.THEMES_LIST_CONTROLLER_URL).forward(req, resp);
    }
}
