package com.example.waleed.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.waleed.recyclerview.adapters.RecAdapter;

public class MainActivity extends AppCompatActivity {
    private final int NUMBER_LIST_ITEMS=100;
    RecyclerView mRecyclerView;
    RecAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView) findViewById(R.id.rec_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        mAdapter=new RecAdapter(NUMBER_LIST_ITEMS);
        mRecyclerView.setAdapter(mAdapter);
    }
}
