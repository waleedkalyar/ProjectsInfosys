package com.example.waleedkalyar.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button buttonA;
    Button buttonB;
    Button buttonC;
    TextView txtView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonA = (Button) findViewById(R.id.btn1);
        buttonB = (Button) findViewById(R.id.btn2);
        buttonC = (Button) findViewById(R.id.btn3);
        txtView = (TextView) findViewById(R.id.txt);
        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn1) {
            txtView.setText("A is clicked");
        }
        if (view.getId() == R.id.btn2) {
            txtView.setText("B is clicked");
        }
        if (view.getId() == R.id.btn3) {
            txtView.setText("C is clicked");
        }
    }
}