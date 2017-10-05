package controller;

import Utils.Constants;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class TestConnection extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/forum_db?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            if (!connection.isClosed()){
                System.err.println("Connected successful");
            }

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Constants.GET_ALL_USERS_NAMES);

            while(resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserLogin(resultSet.getString("user_login"));
                user.setEmail(resultSet.getString("email"));

                System.out.println(user);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
