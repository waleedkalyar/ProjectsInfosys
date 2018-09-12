package com.example.waleedkalyar.mytestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivityWithCustomDesign extends AppCompatActivity {
ListView lstVuCities;
String []gamesArray={"The House Of Dead","Call Of Duty","Need For Speed","Under ground 2","IGI","Counter Strike","Modren Warfare","World War ","IGI2","Mission Impossible","Grand Thef Auto"};
    ArrayAdapter gamesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_with_custom_design);
        lstVuCities=(ListView) findViewById(R.id.lstvu_games);
        gamesAdapter=new ArrayAdapter(this,R.layout.custom_design_for_lstvu,gamesArray);
        lstVuCities.setAdapter(gamesAdapter);
    }
}
