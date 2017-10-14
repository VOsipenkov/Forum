package utils;

import model.Message;
import model.Room;
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
            preparedStatement.setString(1, user.getUserLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setDate(4, null);
            preparedStatement.setInt(5, 1);

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

    public User banUserByLogin(String login) {
        User user = null;

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(Constants.BAN_USER_BY_LOGIN);
            preparedStatement.setString(1, login);

            if (preparedStatement.executeUpdate() != 1) {
                System.err.println("Not found user with login " + login + " for ban");
                return null;
            }

            user = getUserByLogin(login);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public User userLogin(String login, String password) {
        User user = null;

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(Constants.GET_BY_LOGIN_PASSWORD);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if (resultSet.getRow() > 0) {
                user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getInt("role_id"));
                user.setBanToDate(resultSet.getDate("ban_to"));
                user.setEmail(resultSet.getString("email"));
                user.setUserLogin(resultSet.getString("user_login"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public List<Room> getAllThemes() {
        List<Room> rooms = new LinkedList<Room>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(Constants.GET_ALL_THEME_NAMES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Room room = new Room();
                room.setRoom_id(resultSet.getInt("room_id"));
                room.setName(resultSet.getString("name"));
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rooms;
    }

    public List<Message> getAllMessagesByTheme(String theme) {
        List<Message> messages = new LinkedList();
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(Constants.GET_ALL_MESSAGES_FOR_THEME);
            preparedStatement.setString(1, theme);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Message message = new Message();
                message.setMessage_id(resultSet.getInt("message_id"));
                message.setRoom_id(resultSet.getInt("room_id"));
                message.setUser_id(resultSet.getInt("user_id"));
                message.setMessage(resultSet.getString("message"));

                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }
}
