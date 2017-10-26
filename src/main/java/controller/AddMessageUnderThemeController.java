package controller;

import model.Message;
import model.User;
import utils.DBWorker;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddMessageUnderThemeController", urlPatterns = "/addMessage")
public class AddMessageUnderThemeController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        String message = req.getParameter("message");
        String theme = (String)req.getSession().getAttribute("theme");

        DBWorker dbWorker = (DBWorker)getServletContext().getAttribute("dbWorker");
        dbWorker.addMessageUnderTheme(user, theme, message);

        req.getSession().setAttribute("theme", theme);
        List<Message> messages = dbWorker.getAllMessagesByTheme(theme);

        req.setAttribute("theme", theme);
        req.setAttribute("messages", messages);

        req.getRequestDispatcher("/messagesListView").forward(req, resp);
    }
}
