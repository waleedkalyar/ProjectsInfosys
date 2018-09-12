package com.example.waleed.projectsunshine;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.waleed.projectsunshine.adapters.ForcastAdapter;
import com.example.waleed.projectsunshine.data.SunshinePreferences;
import com.example.waleed.projectsunshine.utilities.NetworkUtils;
import com.example.waleed.projectsunshine.utilities.OpenWeatherJsonUtils;

import java.net.URL;

public class MainActivity extends AppCompatActivity implements  ForcastAdapter.ForcastAdapterOnClickHandler,LoaderManager.LoaderCallbacks<String[]>{
    // Complete exe2 (1) Create a field to store the weather display TextView
   RecyclerView mRecyclerView;
    ForcastAdapter mForcastAdapter;
TextView tVErrorMsgDisplay;
    private static final String TAG = MainActivity.class.getSimpleName();
    // complete exe5 (6) Add a TextView variable for the error message display
ProgressBar progressBar;
    private static final int FORECAST_LOADER_ID = 0;
    // complete exe5 (16) Add a ProgressBar variable to show and hide the progress bar
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Complete exe2 (2) Use findViewById to get a reference to the weather display TextView
mRecyclerView=(RecyclerView) findViewById(R.id.recyclerview_forcast);
        // complete exe5 (7) Find the TextView for the error message using findViewById
tVErrorMsgDisplay=(TextView) findViewById(R.id.error_msg_display);
        // complete exe5 (17) Find the ProgressBar using findViewById
        progressBar=(ProgressBar) findViewById(R.id.progressbar_show_progress);


        int loaderId=FORECAST_LOADER_ID;

        LoaderManager.LoaderCallbacks<String[]> callbacks=MainActivity.this;

        Bundle bundleForLoader=null;

        getSupportLoaderManager().initLoader(loaderId,bundleForLoader,callbacks);
        
        // Complete exe3 (4) Delete the dummy weather data. You will be getting REAL data from the Internet in this lesson.
        // Complete exe2 (3) Create an array of Strings that contain fake weather data

        // Complete exe2 (4) Append each String from the fake weather data array to the TextView
        // Complete exe3 (3) Delete the for loop that populates the TextView with dummy data
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);

        mForcastAdapter=new ForcastAdapter(this);

        mRecyclerView.setAdapter(mForcastAdapter);
        // Complete exe3 (9) Call loadWeatherData to perform the network request to get the weather

    }

    // Complete exe3 (8) Create a method that will get the user's preferred location and execute your new AsyncTask and call it loadWeatherData
    // complete exe5 (8) Create a method called showWeatherDataView that will hide the error message and show the weather data
private void showWeatherDataView(){
tVErrorMsgDisplay.setVisibility(View.INVISIBLE);
   mRecyclerView.setVisibility(View.VISIBLE);
}
    // complete exe5 (9) Create a method called showErrorMessage that will hide the weather data and show the error message

private void showErrorMessage(){
    mRecyclerView.setVisibility(View.INVISIBLE);
    tVErrorMsgDisplay.setVisibility(View.VISIBLE);
}

    @Override
    public void onClick(String weatherForDay) {
        Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT,weatherForDay);
        startActivity(intent);
    }

    @Override
    public Loader<String[]> onCreateLoader(int id, Bundle args) {

       return new AsyncTaskLoader<String[]>(this) {
            String[] mWeatherData;
           @Override
           protected void onStartLoading() {
               if (mWeatherData!=null){
                   deliverResult(mWeatherData);
               }else{
                   progressBar.setVisibility(View.VISIBLE);
                   forceLoad();
               }
           }

           @Override
           public String[] loadInBackground() {
               String locationQuery = SunshinePreferences
                       .getPreferredWeatherLocation(MainActivity.this);

               URL weatherRequestUrl = NetworkUtils.buildUrl(locationQuery);

               try {
                   String jsonWeatherResponse = NetworkUtils
                           .getResponseFromHttpUrl(weatherRequestUrl);

                   String[] simpleJsonWeatherData = OpenWeatherJsonUtils
                           .getSimpleWeatherStringsFromJson(MainActivity.this, jsonWeatherResponse);

                   return simpleJsonWeatherData;
               } catch (Exception e) {
                   e.printStackTrace();
                   return null;
               }
           }
           public void deliverResult(String[] data) {
               mWeatherData = data;
               super.deliverResult(data);
           }
       };
    }

    @Override
    public void onLoadFinished(Loader<String[]> loader, String[] data) {
        progressBar.setVisibility(View.INVISIBLE);
        mForcastAdapter.setWeatherData(data);
        if (null == data) {
            showErrorMessage();
        } else {
            showWeatherDataView();
        }
    }

    @Override
    public void onLoaderReset(Loader<String[]> loader) {

    }

    private void invalidateData(){mForcastAdapter.setWeatherData(null);}

    // Complete exe3 (5) Create a class that extends AsyncTask to perform network requests




    // Complete exe4 (2) Create a menu resource in res/menu/ called forecast.xml
    // Complete exe4 (3) Add one item to the menu with an ID of action_refresh
    // Complete exe4 (4) Set the title of the menu item to "Refresh" using strings.xml

    // Complete exe4 (5) Override onCreateOptionsMenu to inflate the menu for this Activity

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main,menu);
        return true;
    }


    private void openLocationInMap() {
        String addressString = "1600 Ampitheatre Parkway, CA";
        Uri geoLocation = Uri.parse("geo:0,0?q=" + addressString);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d(TAG, "Couldn't call " + geoLocation.toString()
                    + ", no receiving apps installed!");
        }
    }


    // Complete exe4 (6) Return true to display the menu

    // Complete exe4 (7) Override onOptionsItemSelected to handle clicks on the refresh button

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int getMenuItenId=item.getItemId();
        if (getMenuItenId==R.id.action_refresh){
            invalidateData();
            getSupportLoaderManager().restartLoader(FORECAST_LOADER_ID, null, this);
            return true;
        }

        if (getMenuItenId==R.id.action_map){
         openLocationInMap();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
