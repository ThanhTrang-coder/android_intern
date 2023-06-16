package edu.hanu.app.test.models;

public class HorizontalModel {
    private int avatar;
    private String user_name;

    public HorizontalModel(int avatar, String user_name) {
        this.avatar = avatar;
        this.user_name = user_name;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
