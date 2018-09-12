package com.example.waleedkalyar.animationpractise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView imgViewTest;
    Animation alphaAnim,translateAnim,scaleAnim,rotateAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgViewTest=(ImageView) findViewById(R.id.imgvu_test);
        alphaAnim= AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha_anim);
        rotateAnim= AnimationUtils.loadAnimation(MainActivity.this,R.anim.rotate_anim);
        scaleAnim= AnimationUtils.loadAnimation(MainActivity.this,R.anim.scale_anim);
        translateAnim= AnimationUtils.loadAnimation(MainActivity.this,R.anim.translate_anim);
    }
    public void rotateImage(View v){
imgViewTest.startAnimation(rotateAnim);
    }
    public void scaleImage(View v){
imgViewTest.startAnimation(scaleAnim);
    }
    public void alphaImage(View v){
        imgViewTest.startAnimation(alphaAnim);

    }
    public void translateImage(View v){
imgViewTest.startAnimation(translateAnim);
    }


}
