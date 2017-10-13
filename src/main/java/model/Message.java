package model;

public class Message {
    private int message_id;
    private int room_id;
    private int user_id;
    private String message;

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
                ", room_id=" + room_id +
                ", user_id=" + user_id +
                ", message='" + message + '\'' +
                '}';
    }
}
