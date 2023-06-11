package edu.hanu.app.Facebook.models;

import android.content.pm.PackageManager;

import java.util.List;

public class FbPost {
    private String user_name_of_post;
    private int user_avatar_of_post;
    private String post_content;
    private int user_image_of_post;
    private int type;
    private List<Photo> photos;
    private int image;
    private String videoUrl;

    public FbPost(int type, String user_name_of_post, int user_avatar_of_post, int user_image_of_post, String post_content) {
        this.type = type;
        this.user_name_of_post = user_name_of_post;
        this.user_avatar_of_post = user_avatar_of_post;
        this.post_content = post_content;
        this.user_image_of_post = user_image_of_post;
    }

    public FbPost(int type, String user_name_of_post, int user_avatar_of_post, List<Photo> photos, String post_content) {
        this.type = type;
        this.user_name_of_post = user_name_of_post;
        this.user_avatar_of_post = user_avatar_of_post;
        this.post_content = post_content;
        this.photos = photos;
    }

    public FbPost(int type, String user_name_of_post, int user_avatar_of_post, String videoUrl, String post_content) {
        this.type = type;
        this.user_name_of_post = user_name_of_post;
        this.user_avatar_of_post = user_avatar_of_post;
        this.post_content = post_content;
        this.videoUrl = videoUrl;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
