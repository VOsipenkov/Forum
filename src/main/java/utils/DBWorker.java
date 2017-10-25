package utils;

import model.Message;
import model.Room;
import model.User;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public interface DBWorker {
    public Connection getConnection();

    public void closeSession();

    public void addUser(User user);

    public List<User> getAllUsers();

    public User getUserByLogin(String login);

    public User banUserByLogin(String login);

    public User userLogin(String login, String password);

    public List<Room> getAllThemes();

    public List<Message> getAllMessagesByTheme(String theme);

    public void addMessageUnderTheme(User user, String theme, String message);
}
