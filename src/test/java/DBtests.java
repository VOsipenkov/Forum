import model.Message;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class DBtests {
    private static Connection connection;
    private static final String TEST_MESSAGE = "this is test message.\n For test issues.";
    private static final int TEST_MESSAGE_ID = 99999;

    private static final String ADD_MESSAGE = "INSERT INTO messages (message_id, room_id, user_id, message) VALUES (?, ?, ?, ?)";
    private static final String GET_ALL_MESSAGES = "SELECT * FROM messages WHERE room_id IN (?) AND user_id IN (?) AND message_id IN (?)";
    private static final String REMOVE_MESSAGE = "DELETE FROM messages WHERE message_id IN (?)";

    @Before
    public void bef() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/forum_db?serverTimezone=UTC", "root", "root");
    }

    @Test
    public void testForCloseConnection() {
        Assert.assertTrue(true);
    }

    @Test
    public void writeMessage() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ADD_MESSAGE);
        preparedStatement.setInt(1, TEST_MESSAGE_ID);
        preparedStatement.setInt(2, 1);
        preparedStatement.setInt(3, 1);
        preparedStatement.setString(4, TEST_MESSAGE);
        Assert.assertEquals(preparedStatement.executeUpdate(), 1);

        preparedStatement = connection.prepareStatement(GET_ALL_MESSAGES);
        preparedStatement.setInt(1, 1);
        preparedStatement.setInt(2, 1);
        preparedStatement.setInt(3, TEST_MESSAGE_ID);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        Message message = new Message();
        message.setMessage(resultSet.getString(4));
        Assert.assertEquals(message.getMessage(), TEST_MESSAGE);

        Assert.assertTrue(true);
    }

    @After
    public void after() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_MESSAGE);
        preparedStatement.setInt(1, TEST_MESSAGE_ID);
        Assert.assertNotEquals(preparedStatement.executeUpdate(), -1);

        if (!connection.isClosed()) {
            connection.close();
        }
    }

}
