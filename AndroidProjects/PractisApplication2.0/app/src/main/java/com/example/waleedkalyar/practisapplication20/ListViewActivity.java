package com.example.waleedkalyar.practisapplication20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {
    ListView lstVuColleges;
    String[] lstArray={"PGC","ILM","READER","Superior","Leader","AL-HIRA","Comprihensive","Dar-e-Arqam","SIT"};
    ArrayAdapter lstAdapterUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        lstVuColleges = (ListView) findViewById(R.id.lst_vu_colleges);
        lstAdapterUser=new ArrayAdapter(this,R.layout.custom_design_for_lstvu,lstArray);
        lstVuColleges.setAdapter(lstAdapterUser);
    }
}






