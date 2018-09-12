package com.example.waleedkalyar.practisapplication20;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.waleedkalyar.practisapplication20.databases.DBMS;

public class AfterLoginActivity extends AppCompatActivity {
TextView txtName,txtEMail,txtAdress;
    String name,eMail,adress;
    Button btnLogOut;
    DBMS dbms;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
        dbms=new DBMS(AfterLoginActivity.this);
        txtName=(TextView) findViewById(R.id.user_info_name);
        txtEMail=(TextView) findViewById(R.id.user_info_email);
        txtAdress=(TextView) findViewById(R.id.user_info_adress);
        btnLogOut=(Button) findViewById(R.id.btn_logout);
        db=dbms.getReadableDatabase();
        //dbms.getUserDataInfo();
    }

}
