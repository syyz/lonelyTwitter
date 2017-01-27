package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Helen on 2017/1/19.
 */

public abstract class Mood {
    private Date date;
    private String moodType;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Mood(String moodType) {
        this.moodType = moodType;
        this.date = new Date();
    }

    public String getMood() {
        return moodType;
    }

    public void setMood(String moodType) {
        this.moodType = moodType;
    }

    public Mood(String moodType, Date date){
        this.moodType = moodType;
        this.date = date;


    }

    public abstract String returnMood();
}
