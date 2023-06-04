package edu.hanu.app.Instagram.models;

import android.content.pm.PackageManager;

public class InsPost {
    private int insAvatar;
    private String insUserName;
    private String insUserDesc;
    private int insImage;

    public InsPost(int insAvatar, String insUserName, String insUserDesc, int insImage) {
        this.insAvatar = insAvatar;
        this.insUserName = insUserName;
        this.insUserDesc = insUserDesc;
        this.insImage = insImage;
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

    public String getInsUserDesc() {
        return insUserDesc;
    }

    public void setInsUserDesc(String insUserDesc) {
        this.insUserDesc = insUserDesc;
    }

    public int getInsImage() {
        return insImage;
    }

    public void setInsImage(int insImage) {
        this.insImage = insImage;
    }
}
