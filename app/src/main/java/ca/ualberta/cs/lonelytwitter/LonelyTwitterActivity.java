package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * This class is the main view class of the project. <br> In this class,
 * user interaction and file mainpulation is performed.
 * All files are in the form of "json"files that are stored in Emulator's
 * accessivle from Android Device Monitor:
 * </pre>
 * <code>begin<br>
 *     some pseduo code here<br>
 * end.</code>
 * The file name is indicated in the &nbsp &nbsp FILENAME constant.
 * <ul>
 * <ol>
 *     <li>item 1</li>
 *     <li>item 2</li>
 *     <li>item 3</li>
 * </ol>
 * </ul>
 *
 * @author Hong Zhou
 * @version 1.4.2
 * @since 1.0
 */
public class LonelyTwitterActivity extends Activity {
	/**
	 * The file that all the tweets are saved here.
	 * The format of the file is JSON.
	 * @see #loadFromFile()
	 * @see #saveInFile()
	 */
	private static final String FILENAME = "file.sav";
    private enum TweetListOrdering {Date_ASCENDING, DATE_DESCENDING, TEXT_ASCENDING};
	private EditText bodyText;
	private ListView oldTweetsList;


	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;//global

    /**
     * Called when the activityis first created
     * @param savedInstanceState
     */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
		clearButton.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				//bodyText.setText("");
				tweetList.clear();
				adapter.notifyDataSetChanged();
				saveInFile();

			}
		});
		saveButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
                text = trimExtraSpace(text);

				Tweet tweet = new NormalTweet(text);

		//		tweetList = new ArrayList<Tweet>();
				tweetList.add(tweet);

				adapter.notifyDataSetChanged();


                saveInFile();


//				saveInFile(text, new Date(System.currentTimeMillis()));
//				finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	//	String[] tweets = loadFromFile();
        loadFromFile();

		 adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

    /**
     * Removes extra space in the given string
     * @param inputString input string
     * @return string without extra space
     */
    private String trimExtraSpace(String inputString){
        inputString = inputString.replace("\\s+"," ");
        return inputString;
    }

    private void sortTweetListItems(TweetListOrdering ordering){}
    /**
     * load tweets from file.
     * @throws TweetTooLongException if the is too long
     * @exception FileNotFoundException IF THE FILE IS NOT CREATED
     */

	private void loadFromFile() {
	//	ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));/*reader is abstract*/
            Gson gson = new Gson();


            //Taken form http://stackoverflow.com/questions/12384064/gson-convert-from
            //2017-01-26 17:53:59
            tweetList = gson.fromJson(in, new TypeToken<ArrayList<NormalTweet>>(){}.getType());//doesnt allow ArrayList<Tweet> as type

            fis.close();

		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	//	return tweets.toArray(new String[tweets.size()]);
	}

    /**
     * Save tweets in file in JSON format.
     * @throws FileNotFoundException if folder not exists
     */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));//write to the file

            Gson gson =  new Gson();
            gson.toJson(tweetList,out);

            out.flush();//flush the writer

			fos.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException();//prevents further damage
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}