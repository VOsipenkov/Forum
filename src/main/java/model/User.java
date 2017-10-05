package model;

import java.util.Date;

public class User {
    private int userId;
    private String userLogin;
    private String email;
    private String role;
    private Date banToDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getBanToDate() {
        return banToDate;
    }

    public void setBanToDate(Date banToDate) {
        this.banToDate = banToDate;
    }

    @Override
    public String toString() {
        return "id: " + userId + " userLogin: " + userLogin + " email: " + email;
    }
}
