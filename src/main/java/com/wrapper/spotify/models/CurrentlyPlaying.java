package com.wrapper.spotify.models;

public class CurrentlyPlaying {
    private Context context;
    private Integer timeStamp;
    private Integer progressMS;
    private boolean isPlaying;
    private Track item;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Integer getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Integer timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getProgressMS() {
        return progressMS;
    }

    public void setProgressMS(Integer progressMS) {
        this.progressMS = progressMS;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public Track getItem() {
        return item;
    }

    public void setItem(Track item) {
        this.item = item;
    }
}
