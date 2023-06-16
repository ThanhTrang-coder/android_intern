package edu.hanu.app.Messenger.models;

public class Model {
    private int imageUrl;
    private String user_name;

    public Model(int imageUrl, String user_name) {
        this.imageUrl = imageUrl;
        this.user_name = user_name;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
