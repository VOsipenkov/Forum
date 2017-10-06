package utils;

import model.User;
import java.sql.Statement;
import java.util.List;

public interface DBWorker {
    public Statement getConnection();

    public void closeSession();

    public void addUser(User user);

    public List<User> getAllUsers();
}
