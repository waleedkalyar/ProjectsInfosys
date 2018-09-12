package com.example.waleed.loglifecycles;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*
    * This tag will be used for logging. It is best practice to use the class's name using
    * getSimpleName as that will greatly help to identify the location from which your logs are
    * being posted.
    */
    private static final String TAG = MainActivity.class.getSimpleName();
    // Completed exe 2 (1) Create a key String called LIFECYCLE_CALLBACKS_TEXT_KEY
private static final String LIFECYCLE_CALLBACKS_TEXT_KEY="callbacks";
    /* Constant values for the names of each respective lifecycle callback */
    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";
    private static final String ON_SAVE_INSTANCE_STATE = "onSaveInstanceState";

    /*
     * This TextView will contain a running log of every lifecycle callback method called from this
     * Activity. This TextView can be reset to its default state by clicking the Button labeled
     * "Reset Log"
     */
    private TextView mLifecycleDisplay;
    // Completed exe 3 (1) Declare and instantiate a static ArrayList of Strings called mLifecycleCallbacks

    private static final ArrayList<String> mLifeCycleCallbacks=new ArrayList<>();

    /**
     * Called when the activity is first created. This is where you should do all of your normal
     * static set up: create views, bind data to lists, etc.
     *
     * Always followed by onStart().
     *
     * @param savedInstanceState The Activity's previously frozen state, if there was one.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLifecycleDisplay = (TextView) findViewById(R.id.tv_lifecycle_events_display);

        // Completed exe 2 (6) If savedInstanceState is not null and contains LIFECYCLE_CALLBACKS_TEXT_KEY, set that text on our TextView
        // Completed (1) Use logAndAppend within onCreate
        if (savedInstanceState!=null){
        if (savedInstanceState.containsKey(LIFECYCLE_CALLBACKS_TEXT_KEY)){
          String allPriviousLifecycleCallbacks=savedInstanceState.getString(LIFECYCLE_CALLBACKS_TEXT_KEY);
            mLifecycleDisplay.setText(allPriviousLifecycleCallbacks);
        }}

        // Completed exe 3 (4) Iterate backwards through mLifecycleCallbacks, appending each String and a newline to mLifecycleDisplay
for (int i=mLifeCycleCallbacks.size()-1;i>=0;i--){
    mLifecycleDisplay.append(mLifeCycleCallbacks.get(i)+"\n");
}
        // Completed exe 3 (5) Clear mLifecycleCallbacks after iterating through it
        mLifeCycleCallbacks.clear();

        logAndAppend(ON_CREATE);
    }

    // Completed (2) Override onStart, call super.onStart, and call logAndAppend with ON_START

    @Override
    protected void onStart() {
        super.onStart();
        logAndAppend(ON_START);
    }

    // Completed (3) Override onResume, call super.onResume, and call logAndAppend with ON_RESUME

    @Override
    protected void onResume() {
        super.onResume();
        logAndAppend(ON_RESUME);
    }

    // Completed (4) Override onPause, call super.onPause, and call logAndAppend with ON_PAUSE

    @Override
    protected void onPause() {
        super.onPause();
        logAndAppend(ON_PAUSE);
    }

    // Completed (5) Override onStop, call super.onStop, and call logAndAppend with ON_STOP

    @Override
    protected void onStop() {
        super.onStop();
        // Completed exe 3 (2) Add the ON_STOP String to the front of mLifecycleCallbacks
        mLifeCycleCallbacks.add(0,ON_STOP);
        logAndAppend(ON_STOP);
    }

    // Completed (6) Override onRestart, call super.onRestart, and call logAndAppend with ON_RESTART

    @Override
    protected void onRestart() {
        super.onRestart();
        logAndAppend(ON_RESTART);
    }


    // Completed (7) Override onDestroy, call super.onDestroy, and call logAndAppend with ON_DESTROY


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Completed exe 3 (3) Add the ON_DESTROY String to the front of mLifecycleCallbacks
        mLifeCycleCallbacks.add(0,ON_DESTROY);
        logAndAppend(ON_DESTROY);
    }

    // Completed exe 2 (2) Override onSaveInstanceState

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        logAndAppend(ON_SAVE_INSTANCE_STATE);
        String lifecycleDisplayTextViewContent=mLifecycleDisplay.getText().toString();
        outState.putString(ON_SAVE_INSTANCE_STATE,lifecycleDisplayTextViewContent);
    }

    // Do steps 3 - 5 within onSaveInstanceState
    // Completed exe 2 (3) Call super.onSaveInstanceState
    // Completed exe 2 (4) Call logAndAppend with the ON_SAVE_INSTANCE_STATE String
    // Completed exe 2 (5) Put the text from the TextView in the outState bundle

    /**
     * Logs to the console and appends the lifecycle method name to the TextView so that you can
     * view the series of method callbacks that are called both from the app and from within
     * Android Studio's Logcat.
     *
     * @param lifecycleEvent The name of the event to be logged.
     */
    private void logAndAppend(String lifecycleEvent) {
        Log.d(TAG, "Lifecycle Event: " + lifecycleEvent);

        mLifecycleDisplay.append(lifecycleEvent + "\n");
    }

    /**
     * This method resets the contents of the TextView to its default text of "Lifecycle callbacks"
     *
     * @param view The View that was clicked. In this case, it is the Button from our layout.
     */
    public void resetLifecycleDisplay(View view) {
        mLifecycleDisplay.setText("Lifecycle callbacks:\n");
    }

}
