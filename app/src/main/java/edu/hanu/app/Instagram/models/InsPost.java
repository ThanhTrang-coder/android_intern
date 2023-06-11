package edu.hanu.app.Instagram.models;

import android.content.pm.PackageManager;

public class InsPost {
    private int insAvatar, insImage;
    private String insUserName, insUserDesc, content_post, commenter_name, comment;

    public InsPost(int insAvatar, int insImage, String insUserName, String insUserDesc, String content_post, String commenter_name, String comment) {
        this.insAvatar = insAvatar;
        this.insImage = insImage;
        this.insUserName = insUserName;
        this.insUserDesc = insUserDesc;
        this.content_post = content_post;
        this.commenter_name = commenter_name;
        this.comment = comment;
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

    public String getContent_post() {
        return content_post;
    }

    public void setContent_post(String content_post) {
        this.content_post = content_post;
    }

    public String getCommenter_name() {
        return commenter_name;
    }

    public void setCommenter_name(String commenter_name) {
        this.commenter_name = commenter_name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
