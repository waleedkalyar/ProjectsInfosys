package com.example.waleedkalyar.mytestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.waleedkalyar.mytestapp.customAdapters.MoviesArrayAdapter;
import com.example.waleedkalyar.mytestapp.models.MoviesModel;

public class LstVuForCustomDesign extends AppCompatActivity {
ListView lstVuCustom;
    MoviesArrayAdapter moviesAdapter;
    MoviesModel[] moviesData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_vu_for_custom_design);
        lstVuCustom=(ListView) findViewById(R.id.lstvu_for_custom_movies);
        moviesData=new MoviesModel[]{new MoviesModel(R.mipmap.ic_launcher,"3Idiots","Amir Khan","25M","2M")};
        moviesAdapter=new MoviesArrayAdapter(LstVuForCustomDesign.this,R.layout.dummy_row_style_movies,moviesData);
        lstVuCustom.setAdapter(moviesAdapter);
    }
}
