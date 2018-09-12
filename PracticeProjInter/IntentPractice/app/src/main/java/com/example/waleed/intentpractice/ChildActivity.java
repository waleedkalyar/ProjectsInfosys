package com.example.waleed.intentpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {
TextView tvIncommingName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        tvIncommingName=(TextView) findViewById(R.id.tv_incomming_data);
        Intent intentThatStartedThisActivity=getIntent();

        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)){
            String getText=intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT);
            tvIncommingName.setText(getText);
        }
    }
}
