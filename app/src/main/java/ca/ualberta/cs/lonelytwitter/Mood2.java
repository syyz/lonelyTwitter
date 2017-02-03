package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This class is for creating Mood2.
 * @author Hong Zhou
 * @version 1.4.2
 * @since 1.0
 */
public class Mood2 extends Mood {

    /**
     * Instantiates a new Mood 2.
     */
    public Mood2() {
        super("Mood2");
    }

    /**
     * Instantiates a new Mood 2.
     *
     * @param moodType the mood type
     * @param date     the date
     */
    public Mood2(String moodType, Date date) {
        super("Mood2", date);
    }


    public String returnMood() {
        return ("Mood1");
    }


}
