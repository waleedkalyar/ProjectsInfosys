package com.example.waleedkalyar.widgetsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView movieListView;
String [] moviesArray={"The Thor","3 Idiots","PK","Iron Man","Back To The Future","X-Man","Hunter","The House Of Dead","Wrong Turn","Live Free or Die","Fast & Furious 8","Go Goa Gone","Kingdom of Heaven","Godzila","Gods of Egept","GramMasala",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_test);
        movieListView=(ListView)findViewById(R.id.movies_listview);
        ArrayAdapter moviesAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,moviesArray);
        movieListView.setAdapter(moviesAdapter);
    }
}
