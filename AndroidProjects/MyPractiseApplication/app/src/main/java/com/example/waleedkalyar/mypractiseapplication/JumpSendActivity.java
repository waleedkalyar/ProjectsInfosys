package com.example.waleedkalyar.mypractiseapplication;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JumpSendActivity extends AppCompatActivity {
    TextView txtForIncomming;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_jump_recive_activity);
        btnSignUp=(Button) findViewById(R.id.login_button_for_signup);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(JumpSendActivity.this,JumpReciveActivity.class));
            }
        });
    }
}