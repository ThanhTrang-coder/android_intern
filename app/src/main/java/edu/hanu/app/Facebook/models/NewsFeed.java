package edu.hanu.app.Facebook.models;

public class NewsFeed {
    private int userAvatar;
    private int otherAvatar;
    private int otherNewsImg;
    private String otherName;
    private boolean isUser;

    public NewsFeed(int otherAvatar, int otherNewsImg, String otherName, boolean isUser) {
        this.otherAvatar = otherAvatar;
        this.otherNewsImg = otherNewsImg;
        this.otherName = otherName;
        this.isUser = isUser;
    }

    public NewsFeed(int userAvatar, boolean isUser) {
        this.userAvatar = userAvatar;
        this.isUser = isUser;
    }

    public int getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(int userAvatar) {
        this.userAvatar = userAvatar;
    }

    public int getOtherAvatar() {
        return otherAvatar;
    }

    public void setOtherAvatar(int otherAvatar) {
        this.otherAvatar = otherAvatar;
    }

    public int getOtherNewsImg() {
        return otherNewsImg;
    }

    public void setOtherNewsImg(int otherNewsImg) {
        this.otherNewsImg = otherNewsImg;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }
}
