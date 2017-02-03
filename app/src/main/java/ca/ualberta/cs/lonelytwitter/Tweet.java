package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class is for creating tweet.
 * @author Hong Zhou
 * @version 1.4.2
 * @since 1.0
 */
public abstract class Tweet implements Tweetable {
    private Date date;
    private String message;
    private ArrayList<Mood> moodList = new ArrayList<Mood>();

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Add mood.
     *
     * @param mood the mood
     */
    public void addMood(Mood mood){
        moodList.add(mood);
    }

    /**
     * Instantiates a new Tweet.
     *
     * @param message the message
     * @param date    the date
     */
    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;

    }

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



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() > 140){
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * Is important boolean.
     *
     * @return the boolean
     */
    public abstract Boolean isImportant();


    @Override
    public String toString(){
        return date.toString() + "|" +message;

    }
}
