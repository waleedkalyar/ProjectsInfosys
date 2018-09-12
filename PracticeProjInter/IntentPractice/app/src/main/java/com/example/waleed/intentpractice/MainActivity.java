package com.example.waleed.intentpractice;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText edName;
    Button btnPassName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edName=(EditText) findViewById(R.id.ed_name_entered);
        btnPassName=(Button) findViewById(R.id.btn_pass_data);
        final String name=edName.getText().toString();
        Context context=MainActivity.this;
        Class DestinationActivity=ChildActivity.class;
btnPassName.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(MainActivity.this,ChildActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT,name);

        startActivity(intent);
    }
});




    }


}
