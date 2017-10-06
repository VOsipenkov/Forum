package utils;

import model.User;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DBWorkerImpl implements DBWorker{
    private String url;
    private String user;
    private String password;
    private Statement statement;
    private Connection connection;

    public DBWorkerImpl(String url, String user, String password){
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Statement getConnection() {
        try {
            if (statement == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(url, user, password);
                if (!connection.isClosed()){
                    System.err.println("Connected successful");
                }

                statement = connection.createStatement();
            }
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException occurs when try to get connection..");
        } catch (SQLException e) {
            System.err.println("SQLException occurs when try to get connection..");
        }

        return statement;
    }

    public void closeSession() {
        try {
            connection.close();
            System.err.println("Connection successfully closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        //todo
    }

    public List<User> getAllUsers() {
        List<User> users = new LinkedList();

        try {
            ResultSet resultSet = getConnection().executeQuery(Constants.GET_ALL_USERS_NAMES);
            while(resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserLogin(resultSet.getString("user_login"));
                user.setEmail(resultSet.getString("email"));
                user.setBanToDate(resultSet.getDate("ban_to"));
                user.setRole(resultSet.getInt("role_id"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
