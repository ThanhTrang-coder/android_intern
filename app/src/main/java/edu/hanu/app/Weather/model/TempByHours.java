package edu.hanu.app.Weather.model;

public class TempByHours {
    private String hours;
    private int iconWeather;
    private String temperature;

    public TempByHours(String hours, int iconWeather, String temperature) {
        this.hours = hours;
        this.iconWeather = iconWeather;
        this.temperature = temperature;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public int getIconWeather() {
        return iconWeather;
    }

    public void setIconWeather(int iconWeather) {
        this.iconWeather = iconWeather;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
