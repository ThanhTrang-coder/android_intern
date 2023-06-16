package edu.hanu.app.Messenger.models;

public class BubbleChat {
    private int type, sender_avatar;
    private String sender_content, receiver_content;

    public BubbleChat(int type, int sender_avatar, String sender_content) {
        this.type = type;
        this.sender_avatar = sender_avatar;
        this.sender_content = sender_content;
    }

    public BubbleChat(int type, String receiver_content) {
        this.type = type;
        this.receiver_content = receiver_content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSender_avatar() {
        return sender_avatar;
    }

    public void setSender_avatar(int sender_avatar) {
        this.sender_avatar = sender_avatar;
    }

    public String getSender_content() {
        return sender_content;
    }

    public void setSender_content(String sender_content) {
        this.sender_content = sender_content;
    }

    public String getReceiver_content() {
        return receiver_content;
    }

    public void setReceiver_content(String receiver_content) {
        this.receiver_content = receiver_content;
    }
}
