package com.hja.feature_home.adapter;

public class ResVideo {

    private String title;
    private String anthor;
    private String time;


    public ResVideo(String title, String anthor, String time) {
        this.title = title;
        this.anthor = anthor;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnthor() {
        return anthor;
    }

    public void setAnthor(String anthor) {
        this.anthor = anthor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
