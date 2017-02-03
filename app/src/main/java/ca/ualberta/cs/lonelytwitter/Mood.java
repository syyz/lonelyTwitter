package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This class is for creating Mood.
 * @author Hong Zhou
 * @version 1.4.2
 * @since 1.0
 */
public abstract class Mood {
    private Date date;
    private String moodType;

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Instantiates a new Mood.
     *
     * @param moodType the mood type
     */
    public Mood(String moodType) {
        this.moodType = moodType;
        this.date = new Date();
    }

    /**
     * Gets mood.
     *
     * @return the mood
     */
    public String getMood() {
        return moodType;
    }

    /**
     * Sets mood.
     *
     * @param moodType the mood type
     */
    public void setMood(String moodType) {
        this.moodType = moodType;
    }

    /**
     * Instantiates a new Mood.
     *
     * @param moodType the mood type
     * @param date     the date
     */
    public Mood(String moodType, Date date){
        this.moodType = moodType;
        this.date = date;


    }

    /**
     * Return mood string.
     *
     * @return the string
     */
    public abstract String returnMood();
}
