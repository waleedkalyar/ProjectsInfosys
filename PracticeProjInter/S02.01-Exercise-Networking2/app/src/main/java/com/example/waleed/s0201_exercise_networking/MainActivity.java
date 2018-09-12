package com.example.waleed.s0201_exercise_networking;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.waleed.s0201_exercise_networking.Utilities.NetworkUtlies;

import java.io.IOException;
import java.net.URL;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
TextView tvUrlDisplay,tvSearchResultDisplay,tvErrorDisplay;
    EditText edSearhQuery;
    ProgressBar pbLoadingIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvUrlDisplay=(TextView) findViewById(R.id.tv_show_url);
        tvSearchResultDisplay=(TextView) findViewById(R.id.tv_show_search_results);
        tvErrorDisplay=(TextView) findViewById(R.id.tv_show_error_message);
        pbLoadingIndicator=(ProgressBar) findViewById(R.id.pb_loading_indicator);
        edSearhQuery=(EditText) findViewById(R.id.ed_search_query);
    }
    private void makeWeatherSearchQuery(){
        String weatherQuery=edSearhQuery.getText().toString();
        URL weatherSearchUrl= NetworkUtlies.buildUrl(weatherQuery);
        tvUrlDisplay.setText(weatherSearchUrl.toString());

        String weatherSearchResult=null;
        new GithubQueryTask().execute(weatherSearchUrl);

    }
    private void showJsonDataView(){
        tvErrorDisplay.setVisibility(View.GONE);
        tvSearchResultDisplay.setVisibility(View.VISIBLE);
    }
    private void showErrorMessage(){
        tvErrorDisplay.setVisibility(View.VISIBLE);
        tvSearchResultDisplay.setVisibility(View.GONE);
    }

    public class GithubQueryTask extends AsyncTask<URL,Void,String> {
        // TODO (26) Override onPreExecute to set the loading indicator to visible
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pbLoadingIndicator.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl=urls[0];
            String githubSearchResult=null;
            try{
                githubSearchResult=NetworkUtlies.getResponceFronHttpUrl(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return githubSearchResult;
        }

        @Override
        protected void onPostExecute(String s) {
            // TODO (27) As soon as the loading is complete, hide the loading indicator
            pbLoadingIndicator.setVisibility(View.INVISIBLE);
            if(s!=null && s.equals("")){
                // TODO (17) Call showJsonDataView if we have valid, non-null results
                showJsonDataView();
                edSearhQuery.setText(s);
            }
            // TODO (16) Call showErrorMessage if the result is null in onPostExecute
            showErrorMessage();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.forecast,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClicked=item.getItemId();
        if(itemThatWasClicked==R.id.refresh_action){
            makeWeatherSearchQuery();

        }
        return true;
    }
}

