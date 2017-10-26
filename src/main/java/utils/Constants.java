package utils;

public class Constants {
    public static final String GET_ALL_USERS_NAMES = "SELECT * FROM users";
    public static final String ADD_USER = "INSERT INTO users (user_login, password, email, ban_to, role_id) VALUES (?,?,?,?,?)";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM users WHERE user_login = ?";
    public static final String BAN_USER_BY_LOGIN = "UPDATE users SET ban_to = ? WHERE user_login = ?";
    public static final String GET_BY_LOGIN_PASSWORD = "SELECT * FROM users WHERE user_login = ? AND password = ?";
    public static final String GET_ALL_ADMINS = "SELECT * FROM users WHERE role_id = 1";
    public static final String GET_ALL_USERS = "SELECT * FROM users WHERE role_id = 2";

    public static final String GET_ALL_MESSAGES_FOR_THEME =
            "SELECT * FROM messages WHERE room_id = (SELECT room_id FROM rooms WHERE name = ?)";
    public static final String GET_ALL_THEME_NAMES =
            "SELECT * FROM rooms";
    public static final String ADD_MESSAGE =
            "INSERT INTO messages (user_id, room_id, message) VALUES (?, ?, ?)";
    public static final String ADD_THEME =
            "INSERT INTO rooms (name) VALUES (?)";
    public static final String REMOVE_MESSAGE =
            "DELETE FROM messages WHERE message_id = ?";
    public static final String REMOVE_THEME =
            "DELETE FROM rooms WHERE room_id = ?";

    public static final String GET_THEME_ID_BY_NAME = "SELECT room_id FROM rooms WHERE name = ?";
    public static final String GET_USERNAME_BY_ID = "SELECT user_login FROM users WHERE user_id = ?";
}
