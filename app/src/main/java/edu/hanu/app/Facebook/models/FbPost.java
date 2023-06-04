package edu.hanu.app.Facebook.models;

import android.content.pm.PackageManager;

public class FbPost {
    private String user_name_of_post;
    private int user_avatar_of_post;
    private String post_content;
    private int user_image_of_post;

    public FbPost(String user_name_of_post, int user_avatar_of_post, int user_image_of_post, String post_content) {
        this.user_name_of_post = user_name_of_post;
        this.user_avatar_of_post = user_avatar_of_post;
        this.post_content = post_content;
        this.user_image_of_post = user_image_of_post;
    }

    public String getUser_name_of_post() {
        return user_name_of_post;
    }

    public void setUser_name_of_post(String user_name_of_post) throws PackageManager.NameNotFoundException {
        if(user_name_of_post.isEmpty()) {
            throw new PackageManager.NameNotFoundException("User name of post is required.");
        }
        this.user_name_of_post = user_name_of_post;
    }

    public int getUser_avatar_of_post() {
        return user_avatar_of_post;
    }

    public void setUser_avatar_of_post(int user_avatar_of_post) {
        this.user_avatar_of_post = user_avatar_of_post;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public int getUser_image_of_post() {
        return user_image_of_post;
    }

    public void setUser_image_of_post(int user_image_of_post) {
        this.user_image_of_post = user_image_of_post;
    }
}
