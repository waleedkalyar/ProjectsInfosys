package com.example.waleedkalyar.sessionmanagerpractise;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.waleedkalyar.sessionmanagerpractise.dbmsPkg.DBMS;
import com.example.waleedkalyar.sessionmanagerpractise.sessionPkg.SessionManager;

public class LoginActivity extends AppCompatActivity {
EditText edttxtEmail,edttxtPass;
    Button btnLogin,btnGoSignUp;
    String email,pass;
    DBMS dbms;
    SQLiteDatabase db;
    SessionManager mSessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mSessionManager=new SessionManager(LoginActivity.this);
        if(mSessionManager.chackUserInSession()==true){
            startActivity(new Intent(LoginActivity.this,HomePageActivity.class));
            finish();
        }

        dbms=new DBMS(LoginActivity.this);
        edttxtEmail=(EditText) findViewById(R.id.login_email);
        edttxtPass=(EditText) findViewById(R.id.login_pass);
        btnLogin=(Button) findViewById(R.id.btn_login);
        btnGoSignUp=(Button) findViewById(R.id.btn_login_to_signup);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=edttxtEmail.getText().toString();
                pass=edttxtPass.getText().toString();
                if(email.isEmpty()||pass.isEmpty()){
                    edttxtEmail.setError("Please Fill");
                    edttxtPass.setError("Please Fill");
                }else{
                    // work with db is here
                    db=dbms.getReadableDatabase();
               Cursor incomCursor= dbms.chackUserLogedIn(db,email,pass);
                    if(incomCursor.getCount()==1){
                        Toast.makeText(LoginActivity.this, "This user is Registered!", Toast.LENGTH_SHORT).show();
                        incomCursor.moveToFirst();
                        String userEmail=incomCursor.getString(2);
                        String userPass=incomCursor.getString(4);
                        mSessionManager.loginTheUser(userEmail,userPass,true);
                        startActivity(new Intent(LoginActivity.this,HomePageActivity.class));
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "The user is Not Register at yet!", Toast.LENGTH_SHORT).show();
                    }
                    edttxtEmail.setText("");
                    edttxtPass.setText("");
                }
            }
        });
        btnGoSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
            }
        });
    }
}
