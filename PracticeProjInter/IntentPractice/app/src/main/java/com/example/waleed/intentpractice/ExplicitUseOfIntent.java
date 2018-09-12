package com.example.waleed.intentpractice;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExplicitUseOfIntent extends AppCompatActivity {
Button btnOpenWeb,getBtnOpenMap,btnShareText,btnCreateOwn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_use_of_intent);
        btnOpenWeb=(Button) findViewById(R.id.btn_open_web);
        getBtnOpenMap=(Button) findViewById(R.id.btn_open_Map);
        btnShareText=(Button) findViewById(R.id.btn_share_text);
        btnCreateOwn=(Button) findViewById(R.id.btn_create_own);
        btnOpenWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String udacityHomePage="http://www.udacity.com";
                openWebPage(udacityHomePage);
            }
        });

getBtnOpenMap.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        onClickOpenAdressButton(view);
    }
});


        btnShareText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mimeType="text/plain";
                String title="Learning how to share";
                String textToShare="Hello there";

                    ShareCompat.IntentBuilder.from(ExplicitUseOfIntent.this)
                        .setChooserTitle(title)
                        .setType(mimeType)
                        .setText(textToShare);


            }
        });
    }
    private void openWebPage(String url){
        Uri webpage=Uri.parse(url);
        Intent intent=new Intent(Intent.ACTION_VIEW,webpage);
        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
}

    private void onClickOpenAdressButton(View view){
        String adressString="1600 Amphitheatre Parkway, CA";

        Uri.Builder builder=new Uri.Builder();
        builder.scheme("geo")
                .path("0,0")
                .query(adressString);
        Uri adressUri=builder.build();

        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(adressUri);
        if (intent.resolveActivity(getPackageManager())!=null)
        startActivity(intent);
    }
}