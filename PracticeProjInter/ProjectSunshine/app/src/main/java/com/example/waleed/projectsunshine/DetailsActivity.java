package com.example.waleed.projectsunshine;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
TextView dayWeatherData;
    String mForcast;
    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
dayWeatherData=(TextView) findViewById(R.id.day_weather_data);
        Intent intentThatStartedThisActivity=getIntent();
        if (intentThatStartedThisActivity!=null){
        mForcast= intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);

        dayWeatherData.setText(mForcast);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.details,menu);
        MenuItem menuItem=menu.findItem(R.id.action_share);
        menuItem.setIntent(createShareForcastIntent());

        return true;
    }

    private Intent createShareForcastIntent() {

        Intent shareIntent= ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText(mForcast+FORECAST_SHARE_HASHTAG)
                .getIntent();
        return shareIntent;
    }
}
