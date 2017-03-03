package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }

    public void testTweet(){
        solo.assertCurrentActivity("Error",LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");
        solo.enterText((EditText)solo.getView(R.id.body),"Test");

        solo.clickOnButton("Save");

        solo.clearEditText((EditText)solo.getView(R.id.body));

        solo.clickOnButton("Clear");

        assertTrue(solo.waitForText("Test"));

    }

        public void testClickTweetList(){
            LonelyTwitterActivity activity = (LonelyTwitterActivity) solo.getCurrentActivity();

            solo.assertCurrentActivity("Error: Wrong Activity",LonelyTwitterActivity.class);

            solo.clickOnButton("Clear");

            solo.enterText((EditText)solo.getView(R.id.body),"Test");

            solo.clickOnButton("Save");
            solo.waitForText("Test");


           final ListView oldTweetsList = activity.getOldTweetList();
            Tweet tweet = (Tweet) oldTweetsList.getItemsAtPosition(0);
            assertEquals("TextView",tweet.getmessage());

            solo.clickInList(0);
            solo.assertCurrentActivity("Error: Wrong Actibity", EditTweetActivity.class);
            assertTrue(solo.waitForText("TextView"));

            solo.goBack();

            solo.assertCurrentActivity("Error: Wrong Activity",LonelyTwitterActivity.class);
        }


    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }

}