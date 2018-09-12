package com.example.waleedkalyar.mytestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText edttxt1;
    EditText edttxt2;
    TextView txtviewR;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practise_me_2);
        edttxt1 = (EditText) findViewById(R.id.edttxt_1stno);
        edttxt2 = (EditText) findViewById(R.id.edttxt_2ndno);
        txtviewR = (TextView) findViewById(R.id.txtview_result);
        buttonAdd = (Button) findViewById(R.id.button_add);
        Intent incomingIntent= getIntent();
        String incomingName=incomingIntent.getStringExtra("Person");
        txtviewR.setText(incomingName);
        Toast.makeText(this, incomingName, Toast.LENGTH_SHORT).show();
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int no1 = Integer.parseInt(edttxt1.getText().toString());
                int no2 = Integer.parseInt(edttxt2.getText().toString());
                int result=no1+no2;

            }
        });
    }
}

   // public void testMethod(View view) {
     //   int no1=Integer.parseInt( edttxt1.getText().toString());
       //int no2=Integer.parseInt( edttxt2.getText().toString());
        //Toast.makeText(this, "The adder is working", Toast.LENGTH_SHORT).show();
        //txtviewR.setText(no1+no2);
  //  }
    //}

