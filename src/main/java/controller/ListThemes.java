package controller;

import model.Room;
import utils.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="listThemes", urlPatterns = {"/listThemes"})
public class ListThemes extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBWorker dbWorker = (DBWorker)getServletContext().getAttribute("dbWorker");
        List<Room> roomList = dbWorker.getAllThemes();
        req.setAttribute("themes", roomList);

        /// /todo go to view wich forward to listMessagesInThemeController added name of room in session scope
    }
}
