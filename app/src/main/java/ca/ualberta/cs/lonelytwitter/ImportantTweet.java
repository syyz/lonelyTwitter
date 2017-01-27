package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Helen on 2017/1/19.
 */

public class ImportantTweet extends Tweet {

    public ImportantTweet(String message) {
        super(message);
    }

    public ImportantTweet(String message, Date date) {
        super(message, date);
    }

    public Boolean isImportant(){
        return true;
    }
}
