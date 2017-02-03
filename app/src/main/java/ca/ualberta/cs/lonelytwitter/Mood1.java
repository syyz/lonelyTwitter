package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This class is for creating Mood1.
 * @author Hong Zhou
 * @version 1.4.2
 * @since 1.0
 */
public class Mood1 extends Mood {

    /**
     * Instantiates a new Mood 1.
     */
    public Mood1() {
        super("Mood1");
    }

    /**
     * Instantiates a new Mood 1.
     *
     * @param date the date
     */
    public Mood1(Date date) {
        super("Mood1", date);
    }


    public String returnMood() {
        return ("Mood1");
    }




}
