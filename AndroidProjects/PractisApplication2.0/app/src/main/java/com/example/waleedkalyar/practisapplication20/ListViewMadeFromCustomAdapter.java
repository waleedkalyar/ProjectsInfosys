package com.example.waleedkalyar.practisapplication20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.waleedkalyar.practisapplication20.customAdapters.MoviesArrayAdapter;
import com.example.waleedkalyar.practisapplication20.dataModels.MoviesModels;

public class ListViewMadeFromCustomAdapter extends AppCompatActivity {
ListView lstvuCustom;
    MoviesArrayAdapter moviesAdapter;
    MoviesModels[] mMoviesModelData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_made_from_custom_adapter);
        lstvuCustom=(ListView) findViewById(R.id.custom_design_lstvu);
        mMoviesModelData=new MoviesModels[]{
                new MoviesModels(R.mipmap.ic_launcher_round,"Titanic","JOHN CARRY","5M","10M"),
                new MoviesModels(R.mipmap.ic_launcher,"Titanic","JOHN CARRY","5M","10M"),
                new MoviesModels(R.mipmap.ic_launcher_round,"Titanic","JOHN CARRY","5M","10M"),
                new MoviesModels(R.mipmap.ic_launcher_round,"Titanic","JOHN CARRY","5M","10M"),
                new MoviesModels(R.mipmap.ic_launcher_round,"Titanic","JOHN CARRY","5M","10M"),
                new MoviesModels(R.mipmap.ic_launcher_round,"Titanic","JOHN CARRY","5M","10M"),
                new MoviesModels(R.mipmap.ic_launcher_round,"Titanic","JOHN CARRY","5M","10M"),};
        moviesAdapter=new MoviesArrayAdapter(ListViewMadeFromCustomAdapter.this,R.layout.dummy_row_style_movies,mMoviesModelData);
        lstvuCustom.setAdapter(moviesAdapter);
    }
}
