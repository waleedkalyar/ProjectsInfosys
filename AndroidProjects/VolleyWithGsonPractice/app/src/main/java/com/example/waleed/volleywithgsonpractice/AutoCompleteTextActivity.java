package com.example.waleed.volleywithgsonpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoCompleteTextActivity extends AppCompatActivity {
AutoCompleteTextView textViewAutoComplete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text);

        textViewAutoComplete=(AutoCompleteTextView) findViewById(R.id.textViewAutoComplete);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,COUNTRIES);
        textViewAutoComplete.setAdapter(adapter);


    }
private static final String[] COUNTRIES=new String[]{"Pakistan","India","Afghanistan","U.K","U.S.A","U.A.E","Israil","Iran","Iraq"};

}
