package com.example.waleedkalyar.fragmentpractisehomework;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.waleedkalyar.fragmentpractisehomework.customAdapters.NewsAdapter;
import com.example.waleedkalyar.fragmentpractisehomework.fragmentsPakage.InternationalNews;
import com.example.waleedkalyar.fragmentpractisehomework.fragmentsPakage.NationalNews;
import com.example.waleedkalyar.fragmentpractisehomework.fragmentsPakage.SportsNews;
import com.example.waleedkalyar.fragmentpractisehomework.fragmentsPakage.WeatherNews;
import com.example.waleedkalyar.fragmentpractisehomework.newsModel.NewsModel;

public class MainActivity extends AppCompatActivity {
ListView newsList;
    NewsModel[] newsModel;
    NewsAdapter newsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsList=(ListView) findViewById(R.id.lst_vu_with_frag);

        InternationalNews internationalNews=new InternationalNews();
        final NationalNews nationalNews = new NationalNews();
        SportsNews sportsNews=new SportsNews();
        WeatherNews weatherNews=new WeatherNews();
        final Fragment[] fragsArray={internationalNews,nationalNews,sportsNews,weatherNews};

        newsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                try{

                openNewFragment(fragsArray[i]);}
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Please select only above four", Toast.LENGTH_SHORT).show();
                }




            }
        });


        newsModel=new NewsModel[]{
                new NewsModel(R.drawable.key_arrow_down,"International"),
                new NewsModel(R.drawable.key_arrow_down,"National"),
                new NewsModel(R.drawable.key_arrow_down,"Sports"),
                new NewsModel(R.drawable.key_arrow_down,"Weather"),
                new NewsModel(R.drawable.key_arrow_down,"Scince & Technology"),
                new NewsModel(R.drawable.key_arrow_down,"Arts & fun"),
                new NewsModel(R.drawable.key_arrow_down,"Bollywood"),
                new NewsModel(R.drawable.key_arrow_down,"Hollywood"),
                new NewsModel(R.drawable.key_arrow_down,"Blogs"),
                new NewsModel(R.drawable.key_arrow_down,"Columns")};
        newsAdapter=new NewsAdapter(MainActivity.this, R.layout.dummy_style_for_lstvu,newsModel);
        newsList.setAdapter(newsAdapter);
        // here we set fragments on each item of lstvu

    }

    public void openNewFragment(Fragment mFrag){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_show_frag,mFrag);
        fragmentTransaction.commit();

    }
}
