package ca.ualberta.cs.lonelytwitter;

/**
 * Created by Helen on 2017/1/19.
 */

public interface Tweetable {
    public String getMessage();
    public void setMessage(String string) throws TweetTooLongException;


}
