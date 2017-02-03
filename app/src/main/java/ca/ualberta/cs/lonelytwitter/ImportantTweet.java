package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This class is for creating Important tweet.
 * @author Hong Zhou
 * @version 1.4.2
 * @since 1.0
 */
public class ImportantTweet extends Tweet {

    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     */
    public ImportantTweet(String message) {
        super(message);
    }

    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     * @param date    the date
     */
    public ImportantTweet(String message, Date date) {
        super(message, date);
    }

    public Boolean isImportant(){
        return true;
    }
}
