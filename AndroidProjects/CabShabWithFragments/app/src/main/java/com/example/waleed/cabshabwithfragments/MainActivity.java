package com.example.waleed.cabshabwithfragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.waleed.cabshabwithfragments.fragPkg.LoginFrag;
import com.example.waleed.cabshabwithfragments.fragPkg.WelcomeFrag;

public class MainActivity extends AppCompatActivity {
Button btnWelcome,btnLogin,BtnHome,btnMore,btnSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnWelcome=(Button) findViewById(R.id.btn_welcome);
        btnLogin=(Button) findViewById(R.id.btn_login);
        BtnHome=(Button) findViewById(R.id.btn_home);
        btnMore=(Button) findViewById(R.id.btn_more);
        btnSettings=(Button) findViewById(R.id.btn_settings);

        btnWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WelcomeFrag welcomeFrag=new WelcomeFrag();
                openNewFragment(welcomeFrag);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginFrag loginFrag=new LoginFrag();
                openNewFragment(loginFrag);
            }
        });

    }

    public void openNewFragment(Fragment mFrag){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout_frag_loader,mFrag);
        fragmentTransaction.commit();
    }

}
