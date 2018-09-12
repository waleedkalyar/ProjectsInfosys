package com.example.waleedkalyar.animwithsplash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class SplashScreenActivity extends AppCompatActivity {
ImageView splashimg;
    Animation alphaAnim,translateAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        splashimg=(ImageView) findViewById(R.id.imgvu_splah);
        alphaAnim= AnimationUtils.loadAnimation(SplashScreenActivity.this,R.anim.alpha_anim);
        translateAnim= AnimationUtils.loadAnimation(SplashScreenActivity.this,R.anim.translate_anim);
        Thread splashThread=new Thread(){
            @Override
            public void run() {
                try{
                    alphaRun();
                    translateRun();
                    Thread.sleep(11000);
                    Intent myIntent=new Intent(SplashScreenActivity.this,MainActivity.class);
                    startActivity(myIntent);
                    finish();
                }
                catch(Exception e){
                }
                super.run();
            }
        };
        splashThread.start();
    }
    public void alphaRun(){
        splashimg.startAnimation(alphaAnim);
    }
    public void translateRun(){
        splashimg.startAnimation(translateAnim);
    }
}
