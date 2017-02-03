package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This class is for creating Normal tweet.
 * @author Hong Zhou
 * @version 1.4.2
 * @since 1.0
 */
public class NormalTweet extends Tweet {
    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     */
    public NormalTweet(String message) {
        super(message);
    }

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     * @param date    the date
     */
    public NormalTweet(String message, Date date) {
        super(message, date);
    }

    /**
     *
     * @return a boolean type shows if the tweet is important
     */
    public Boolean isImportant(){
        return false;
    }
}
