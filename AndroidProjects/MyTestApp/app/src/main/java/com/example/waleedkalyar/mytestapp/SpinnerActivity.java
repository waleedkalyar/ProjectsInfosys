package com.example.waleedkalyar.mytestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SpinnerActivity extends AppCompatActivity {
Button btnGoTOLst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        btnGoTOLst=(Button) findViewById(R.id.btn_go_to_lst);
        btnGoTOLst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SpinnerActivity.this, "we are going to next Activity", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(SpinnerActivity.this,ListViewActivityWithCustomDesign.class));
            }
        });
    }
}
