package controller;

import utils.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListMessagesInTheme extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBWorker dbWorker = (DBWorker)getServletContext().getAttribute("dbWorker");
        String theme = null;//todo get this theme
        dbWorker.getAllMessagesByTheme(theme);
        //todo show this messages
    }
}
