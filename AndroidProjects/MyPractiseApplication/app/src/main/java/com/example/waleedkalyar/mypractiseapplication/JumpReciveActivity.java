package com.example.waleedkalyar.mypractiseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class JumpReciveActivity extends AppCompatActivity {
TextView txtForIncomming;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_jump_recive_activity);
        txtForIncomming=(TextView)findViewById(R.id.txtView_for_incomming_txt);
        Intent inCommingIntent=getIntent();
        String getTxt=inCommingIntent.getStringExtra("Text");
        txtForIncomming.setText(getTxt);
    }
}
