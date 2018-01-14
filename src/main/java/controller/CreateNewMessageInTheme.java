package controller;

import model.Message;
import model.User;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import utils.DBWorker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static utils.Constants.DB_WORKER;
import static utils.UrlConstants.MESSAGES_LIST_CONTROLLER_URL;

@WebServlet(name = "createNewMessageInTheme", urlPatterns = "/messages/create", loadOnStartup = 2)
public class CreateNewMessageInTheme extends HttpServlet {
    String lastMessage;
    String lastSessionId;
    User lastUser;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String message = req.getParameter("message");
        String theme = (String) req.getSession().getAttribute("theme");

        if ( StringUtils.isEmpty(message.replaceAll("[\t, \n]", ""))){
            req.getRequestDispatcher(MESSAGES_LIST_CONTROLLER_URL).forward(req, resp);
        }

        if (isNotDDOS(req)) {
            DBWorker dbWorker = (DBWorker) getServletContext().getAttribute(DB_WORKER);
            dbWorker.addMessageUnderTheme(user, theme, message);

            List<Message> messages = dbWorker.getAllMessagesByTheme(theme);
            req.setAttribute("messages", messages);
        }

        req.getRequestDispatcher(MESSAGES_LIST_CONTROLLER_URL).forward(req, resp);
    }

    private boolean isNotDDOS(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        String message = req.getParameter("message");

        if (!StringUtils.equals(req.getRequestedSessionId(), lastSessionId)) {
            saveParams(user, message, req.getRequestedSessionId());
            return true;
        } else if(ObjectUtils.notEqual(user, lastUser)){
            saveParams(user, message, req.getRequestedSessionId());
            return true;
        } else if (!StringUtils.equals(lastMessage, message)){
            saveParams(user, message, req.getRequestedSessionId());
            return true;
        } else {
            return false;
        }
    }

    private void saveParams(User user, String message, String sessionId){
        lastUser = user;
        lastMessage = message;
        lastSessionId = sessionId;
    }
}
