package com.example.waleedkalyar.fragmentpractise;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.waleedkalyar.fragmentpractise.fragPakges.BlankFragment1;
import com.example.waleedkalyar.fragmentpractise.fragPakges.BlankFragment2;
import com.example.waleedkalyar.fragmentpractise.fragPakges.BlankFragment3;

public class MainActivity extends AppCompatActivity {
Button btnF1,btnF2,btnF3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnF1=(Button) findViewById(R.id.btn_1_frg);
        btnF2=(Button) findViewById(R.id.btn_2_frg);
        btnF3=(Button) findViewById(R.id.btn_3_frg);
        btnF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlankFragment1 blankFragment1=new BlankFragment1();
                openNewFragment(blankFragment1);
            }
        });

        btnF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlankFragment2 blankFragment2=new BlankFragment2();
                openNewFragment(blankFragment2);
            }
        });

        btnF3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BlankFragment3 blankFragment3=new BlankFragment3();
                openNewFragment(blankFragment3);
            }
        });
    }
    public  void openNewFragment(Fragment mFrag){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_containor,mFrag);
        fragmentTransaction.commit();
    }
}
