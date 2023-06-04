package edu.hanu.app.Facebook.models;

import android.content.pm.PackageManager;

public class FbStory {
    private int userAvatar;
    private int userStoryImg;
    private String userName;
    private boolean isUser;

    public FbStory(int userAvatar, boolean isUser) {
        this.userAvatar = userAvatar;
        this.isUser = isUser;
    }

    public FbStory(int userAvatar, int userStoryImg, String userName, boolean isUser) {
        this(userAvatar, isUser);
        this.userStoryImg = userStoryImg;
        this.userName = userName;
    }

    public int getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(int userAvatar){
        this.userAvatar = userAvatar;
    }

    public int getUserStoryImg() {
        return userStoryImg;
    }

    public void setUserStoryImg(int userStoryImg) throws Exception{
        this.userStoryImg = userStoryImg;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) throws PackageManager.NameNotFoundException {
        if(userName.isEmpty()) {
            throw new PackageManager.NameNotFoundException("User name is invalid");
        }
        this.userName = userName;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }
}
