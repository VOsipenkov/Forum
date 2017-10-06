package utils;

public class Constants {
    public static final String GET_ALL_USERS_NAMES = "SELECT * FROM users";
    public static final String ADD_USER = "INSERT INTO users (user_login, email, ban_to, role_id) VALUES (?,?,?,?)";
}
