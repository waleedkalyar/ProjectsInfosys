package com.example.waleedkalyar.mytestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.waleedkalyar.mytestapp.R;

public class BikerSignIn extends AppCompatActivity {
    EditText edtTxtName;
    EditText edtTxtPassword;
    Button buttonLogin;
    Button buttonSignUpLogIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biker_signin);
        edtTxtName=(EditText)findViewById(R.id.edttxt_login_name);
        edtTxtPassword=(EditText)findViewById(R.id.edttxt_login_password);
        buttonLogin=(Button)findViewById(R.id.login_button_for_login);
        buttonSignUpLogIn=(Button)findViewById(R.id.login_button_for_signup);
        buttonSignUpLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BikerSignIn.this, "SignUp is in process", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(BikerSignIn.this,BikerSignUp.class);
                intent.putExtra("Person",edtTxtName.getText().toString());
                startActivity(intent);
                finish();

            }
        });
    }
}
