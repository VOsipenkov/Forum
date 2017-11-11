package controller;

import model.Message;
import utils.DBWorker;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="listMessagesInThemeController", urlPatterns = {"/listMessagesInThemeController"})
public class ListMessagesInTheme extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBWorker dbWorker = (DBWorker)getServletContext().getAttribute("dbWorker");

        String theme = req.getParameter("theme");
        req.getSession().setAttribute("theme", theme);

        List<Message> messages = dbWorker.getAllMessagesByTheme(theme);
        req.setAttribute("messages", messages);

        req.getRequestDispatcher("/messagesListView").forward(req, resp);
    }
}
