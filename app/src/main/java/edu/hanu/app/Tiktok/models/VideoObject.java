package edu.hanu.app.Tiktok.models;

public class VideoObject {
    public String videoUrl, user_name, videoDesc, videoHastag, music_name;

    public VideoObject(String videoUrl, String user_name, String videoDesc, String videoHastag, String music_name) {
        this.videoUrl = videoUrl;
        this.user_name = user_name;
        this.videoDesc = videoDesc;
        this.videoHastag = videoHastag;
        this.music_name = music_name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }

    public String getVideoHastag() {
        return videoHastag;
    }

    public void setVideoHastag(String videoHastag) {
        this.videoHastag = videoHastag;
    }

    public String getMusic_name() {
        return music_name;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }
}
