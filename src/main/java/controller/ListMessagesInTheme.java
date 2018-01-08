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

import static utils.Constants.DB_WORKER;

@WebServlet(name = "listMessagesInThemeController", urlPatterns = {"/listMessagesInThemeController"})
public class ListMessagesInTheme extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBWorker dbWorker = (DBWorker) getServletContext().getAttribute(DB_WORKER);

        String theme = req.getParameter("theme");
        if (theme == null) {
            theme = (String) req.getSession().getAttribute("theme");
        }
        req.getSession().setAttribute("theme", theme);

        List<Message> messages = dbWorker.getAllMessagesByTheme(theme);
        req.setAttribute("messages", messages);

        req.getRequestDispatcher("/messagesListView").forward(req, resp);
    }
}
