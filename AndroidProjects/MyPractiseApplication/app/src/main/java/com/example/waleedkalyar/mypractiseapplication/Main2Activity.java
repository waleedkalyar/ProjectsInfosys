package com.example.waleedkalyar.mypractiseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView txtViewPage2;
    Button buttonPage2;
    EditText edtTxtPage2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page_layout);
        Intent incomingIntent=getIntent();
        String incomingName=incomingIntent.getStringExtra("Person");
        edtTxtPage2=(EditText)findViewById(R.id.edtTxt_page2);
        txtViewPage2=(TextView)findViewById(R.id.textView_page2);
        buttonPage2=(Button) findViewById(R.id.button_enter_page2);
                txtViewPage2.setText(incomingName);
                Toast.makeText(Main2Activity.this, incomingName, Toast.LENGTH_SHORT).show();
            }
        }


