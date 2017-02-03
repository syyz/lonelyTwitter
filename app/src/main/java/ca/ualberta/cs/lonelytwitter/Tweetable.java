package ca.ualberta.cs.lonelytwitter;

/**
 * This class is for making tweet tweetable in the interface.
 * @author Hong Zhou
 * @version 1.4.2
 * @since 1.0
 */
public interface Tweetable {
    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage();

    /**
     * Sets message.
     *
     * @param string the string
     * @throws TweetTooLongException the tweet too long exception
     */
    public void setMessage(String string) throws TweetTooLongException;


}
