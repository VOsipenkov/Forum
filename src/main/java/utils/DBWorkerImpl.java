package utils;

import model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static utils.Constants.GET_USER_BY_LOGIN;

public class DBWorkerImpl implements DBWorker {
    private String url;
    private String user;
    private String password;
    private Connection connection;

    public DBWorkerImpl(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);

                if (!connection.isClosed()) {
                    System.err.println("Connected successful");
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return connection;
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
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(Constants.ADD_USER);
            preparedStatement.setString(1, "login555");
            preparedStatement.setString(2, "email555");
            preparedStatement.setDate(3, null);
            preparedStatement.setInt(4, 1);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new LinkedList();

        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(Constants.GET_ALL_USERS_NAMES);
            while (resultSet.next()) {
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

    public User getUserByLogin(String login) {
        User user = null;

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(Constants.GET_USER_BY_LOGIN);
            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            user.setUserId(resultSet.getInt("user_id"));
            user.setUserLogin(resultSet.getString("user_login"));
            user.setEmail(resultSet.getString("email"));
            user.setBanToDate(resultSet.getDate("ban_to"));
            user.setRole(resultSet.getInt("role_id"));
            user.setPassword(resultSet.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public User banUserByLogin(String login){
        User user = null;

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(Constants.BAN_USER_BY_LOGIN);
            preparedStatement.setString(1, login);

            if (preparedStatement.executeUpdate() != 1){
                System.err.println("Not found user with login " + login + " for ban");
                return null;
            }

            user = getUserByLogin(login);

        }catch (SQLException e){
            e.printStackTrace();
        }

        return user;
    }
}
