package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Helen on 2017/3/3.
 */

public class EditTweetActivity extends Activity{
    @Override
    protected void onCeate(Bundle saveInstancesState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);

    Bundle bundle = getIntent().getExtras();
    String testString = bundle.getString("testString");
    }
}
}
