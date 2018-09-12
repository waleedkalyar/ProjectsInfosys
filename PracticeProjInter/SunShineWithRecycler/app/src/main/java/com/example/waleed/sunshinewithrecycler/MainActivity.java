package com.example.waleed.sunshinewithrecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.waleed.sunshinewithrecycler.adapters.SunShineAdapter;

public class MainActivity extends AppCompatActivity
implements SunShineAdapter.ListItemClickListner{
private  int[] date;
private  int[] weather;
    private int[] month;
    RecyclerView weatherList;
    SunShineAdapter mAdapter;
    int nowDate;
    int nowWeather;
    int nowMonth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherList=(RecyclerView) findViewById(R.id.sunshine_rec_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        weatherList.setLayoutManager(layoutManager);
        weatherList.setHasFixedSize(true);

       this.date=new int[30];
        this.month=new int[12];
      this.weather=new int[]{31,42,58,51};

       // int i=0,j=0,k=0;

         //   do {
           //     if (i<date.length && j<month.length && k<weather.length){
             //      nowDate=date[i];
               //    nowMonth=month[j];
                 //  nowWeather=weather[k];
                   // i++;j++;k++;
        nowDate=30;
        nowMonth=2;
        nowWeather=4;
                     mAdapter = new SunShineAdapter(nowDate,nowMonth, nowWeather, this);
                    weatherList.setAdapter(mAdapter);
               // }

            //}
          //  while (true);


        }



    @Override
    public void onListItemClick(int clickedItemIndex) {
        String toastMessage= "Date "+clickedItemIndex+" is Clicked!";
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }
}
