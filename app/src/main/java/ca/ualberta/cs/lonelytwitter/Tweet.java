package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Helen on 2017/1/19.
 */

public abstract class Tweet implements Tweetable {
    private Date date;
    private String message;
    private ArrayList<Mood> moodList = new ArrayList<Mood>();
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public void addMood(Mood mood){
        moodList.add(mood);
    }

    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;

    }

    public Date getDate() {
        return date;
    }

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

    public abstract Boolean isImportant();


    @Override
    public String toString(){
        return date.toString() + "|" +message;

    }
}
