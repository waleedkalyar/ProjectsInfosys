package com.example.waleedkalyar.drawerpractise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
ImageView imgvuSplah;
    Animation alpha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imgvuSplah=(ImageView) findViewById(R.id.img_vu_splash_anim);
        alpha= AnimationUtils.loadAnimation(SplashActivity.this,R.anim.alpha_anim);
       Thread splashThread=new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(6000);
                    animAlpha(imgvuSplah);
                    Intent mIntent=new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(mIntent);
                }catch (Exception e){

                }
                super.run();
            }
        };
        splashThread.start();

    }
    /* the start of thread is important after completing object of Thread in the same method*/

    public void animAlpha(ImageView imgvuSplah){
        imgvuSplah.startAnimation(alpha);

    }

}
