package edu.hanu.app.Pinterest.models;

public class Craft {
    private int imageUrl;
    private String name;

    public Craft(int imageUrl, String name) {
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        if(name == null) {
            return "N/A";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
