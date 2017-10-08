package utils;

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
}
