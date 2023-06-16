package edu.hanu.app.Messenger.models;

public class Model2 {
    private int imageUrl;
    private String user_name, content;

    public Model2(int imageUrl, String user_name, String content) {
        this.imageUrl = imageUrl;
        this.user_name = user_name;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
