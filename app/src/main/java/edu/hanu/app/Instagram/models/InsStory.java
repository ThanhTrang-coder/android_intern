package edu.hanu.app.Instagram.models;

import android.content.pm.PackageManager;

public class InsStory {
    private int insAvatar;
    private String insUserName;
    private boolean isUser;

    public InsStory(int insAvatar, String insUserName, boolean isUser) {
        this.insAvatar = insAvatar;
        this.insUserName = insUserName;
        this.isUser = isUser;
    }

    public int getInsAvatar() {
        return insAvatar;
    }

    public void setInsAvatar(int insAvatar) {
        this.insAvatar = insAvatar;
    }

    public String getInsUserName() {
        return insUserName;
    }

    public void setInsUserName(String insUserName) throws PackageManager.NameNotFoundException {
        if(insUserName.isEmpty()) {
            throw new PackageManager.NameNotFoundException("User name is required.");
        }
        this.insUserName = insUserName;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }
}
