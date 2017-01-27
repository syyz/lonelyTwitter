package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Helen on 2017/1/19.
 */

public class NormalTweet extends Tweet {
    public NormalTweet(String message) {
        super(message);
    }

    public NormalTweet(String message, Date date) {
        super(message, date);
    }
    public Boolean isImportant(){
        return false;
    }
}
