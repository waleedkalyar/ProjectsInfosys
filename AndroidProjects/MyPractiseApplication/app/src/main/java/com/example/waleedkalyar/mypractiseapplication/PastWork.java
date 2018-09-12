package com.example.waleedkalyar.mypractiseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PastWork extends AppCompatActivity {
    TextView txtViewPage1;
    Button buttonPage1;
    EditText edtTxtPage1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtPage1=(EditText)findViewById(R.id.edtTxt_page1);
        txtViewPage1=(TextView)findViewById(R.id.textView_page1);
        buttonPage1=(Button) findViewById(R.id.button_enter_page1);
        buttonPage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PastWork.this, "Hello Toast", Toast.LENGTH_SHORT).show();
                txtViewPage1.setText(edtTxtPage1.getText().toString());
                Intent intent=new Intent(PastWork.this,Main2Activity.class);
                startActivity(intent);
                intent.putExtra("Person",edtTxtPage1.getText().toString());

            }
        });

    }
}
