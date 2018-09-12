package com.example.waleedkalyar.widgetsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerAgeActivity extends AppCompatActivity {
Spinner spinnerAges;
    Button btnGoToNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_age);
        spinnerAges=(Spinner) findViewById(R.id.spinner_ages);
        btnGoToNext=(Button) findViewById(R.id.btn_gotonext);
        spinnerAges.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
             //  String position=String.valueOf(i);   /*It converts position given in int to String*/
               // String views=((TextView)view).getText().toString();    /*it convert view into "TextView and then it to String"*/
                //Toast.makeText(SpinnerAgeActivity.this, "position is"+position+" View is"+views, Toast.LENGTH_SHORT).show();  /*it display both position and view use with upper two lines*/
                //Toast.makeText(SpinnerAgeActivity.this,String.valueOf(i), Toast.LENGTH_SHORT).show();  /*toast only position*/
                Toast.makeText(SpinnerAgeActivity.this, ((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();  /*toast only view*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
btnGoToNext.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(SpinnerAgeActivity.this,ListViewActivity.class);
        startActivity(intent);
    }
});
    }
}
