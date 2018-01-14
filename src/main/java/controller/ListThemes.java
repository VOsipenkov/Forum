package controller;

import model.Room;
import utils.DBWorker;
import utils.UrlConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static utils.Constants.DB_WORKER;

@WebServlet(name="listThemes", urlPatterns = {"/themes/list"})
public class ListThemes extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBWorker dbWorker = (DBWorker)getServletContext().getAttribute(DB_WORKER);
        List<Room> roomList = dbWorker.getAllThemes();
        req.setAttribute("themes", roomList);

        req.getRequestDispatcher(UrlConstants.THEMES_LIST_VIEW_URL).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
