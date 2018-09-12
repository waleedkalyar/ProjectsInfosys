package com.example.waleedkalyar.sessionmanagerpractise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.waleedkalyar.sessionmanagerpractise.sessionPkg.SessionManager;

public class MainActivity extends AppCompatActivity {
SessionManager mSessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSessionManager=new SessionManager(MainActivity.this);

        mSessionManager.loginTheUser("wali@hotmail.com","hellouser",true);

        String prefEmail=mSessionManager.chackUserInSessionEmail();
        String prefPass=mSessionManager.chackUserInSessionPass();
        boolean prefLogType=mSessionManager.chackUserInSession();



        Toast.makeText(this, prefEmail, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, prefPass, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, mSessionManager.chackUserInSession()+"", Toast.LENGTH_SHORT).show();
    }
}
