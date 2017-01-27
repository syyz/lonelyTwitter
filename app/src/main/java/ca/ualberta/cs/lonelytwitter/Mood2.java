package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Helen on 2017/1/19.
 */

public class Mood2 extends Mood {

    public Mood2() {
        super("Mood2");
    }

    public Mood2(String moodType, Date date) {
        super("Mood2", date);
    }


    public String returnMood() {
        return ("Mood1");
    }


}
