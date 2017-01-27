package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Helen on 2017/1/19.
 */

public class Mood1 extends Mood {

    public Mood1() {
        super("Mood1");
    }

    public Mood1(Date date) {
        super("Mood1", date);
    }


    public String returnMood() {
        return ("Mood1");
    }




}
