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

public class BikerSignUp extends AppCompatActivity {
    EditText edtTxtSignUpName;
    EditText edtTxtSignUpEMail;
    EditText edtTxtSignUpContectNo;
    EditText edtTxtSignUpPassword;
    Button buttonSignUp;
    TextView txtViewIncomingName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.biker_signup);
        edtTxtSignUpName=(EditText)findViewById(R.id.edttxt_signup_name);
        edtTxtSignUpEMail=(EditText)findViewById(R.id.edttxt_signup_e_mail);
        edtTxtSignUpContectNo=(EditText)findViewById(R.id.edttxt_signup_contectno);
        edtTxtSignUpPassword=(EditText)findViewById(R.id.edttxt_signup_password);
        buttonSignUp=(Button)findViewById(R.id.signup_button_signup);
        txtViewIncomingName=(TextView)findViewById(R.id.txtview_incoming_name);
        Intent incomingIntent=getIntent();
        String PersonName=incomingIntent.getStringExtra("Person");
        txtViewIncomingName.setText(PersonName);
    }
}