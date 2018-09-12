package com.example.waleedkalyar.mypractiseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogInDesign extends AppCompatActivity {
Button btnSignUpInLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_design);
        btnSignUpInLogin=(Button) findViewById(R.id.login_button_for_signup);
        btnSignUpInLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LogInDesign.this,SignUpDesign.class);
                startActivity(intent);
            }
        });
    }
}
