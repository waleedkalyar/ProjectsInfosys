package com.example.waleedkalyar.widgetsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {
ListView lstVu;
    String []countriesArray={"PAKISTAN","INDIA","SRILANKA","AFGANISTAN","BNGLADESH","BHOTAN","NEPAL","EGEPT","TURKI","ISRAIL","USA","UAE","UK","SAUDI-ARAB","IRAN","IRAQ","FRANCE"};
    ArrayAdapter countriesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        lstVu=(ListView) findViewById(R.id.list_view_countries);
        countriesAdapter=new ArrayAdapter(this,R.layout.custom_design_for_lstvu,countriesArray);
        lstVu.setAdapter(countriesAdapter);
        lstVu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, ((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
