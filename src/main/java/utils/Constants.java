package utils;

public class Constants {
    public static final String GET_ALL_USERS_NAMES = "SELECT * FROM users";
    public static final String ADD_USER = "INSERT INTO users (user_login, email, ban_to, role_id) VALUES (?,?,?,?)";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM users WHERE user_login = ?";
    public static final String BAN_USER_BY_LOGIN = "UPDATE users SET ban_to = ? WHERE user_login = ?";
}
