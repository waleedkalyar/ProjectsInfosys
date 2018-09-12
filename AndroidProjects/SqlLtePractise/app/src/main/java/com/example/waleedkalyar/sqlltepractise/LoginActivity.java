package com.example.waleedkalyar.sqlltepractise;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.waleedkalyar.sqlltepractise.dbmsPkg.DBMS;

public class LoginActivity extends AppCompatActivity {
EditText edtTxtName,EdtTxtPass;
String userName,pass;
    Button btnLogin;
    DBMS dbms;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbms=new DBMS(LoginActivity.this);
        edtTxtName=(EditText) findViewById(R.id.edt_txt_login_name);
        EdtTxtPass=(EditText) findViewById(R.id.edt_txt_login_password);
        btnLogin=(Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName=edtTxtName.getText().toString();
                pass=EdtTxtPass.getText().toString();
                if(userName.isEmpty()||pass.isEmpty()){
                    edtTxtName.setError("Not Filled");
                    EdtTxtPass.setError("Not Filled");
                }
                else{
                    // here we chack the user is register or not
                    db=dbms.getReadableDatabase();
                    Cursor c = dbms.chackUserLogedIn(db,userName,pass);
                    if(c.getCount()==1){
                        Toast.makeText(LoginActivity.this, "User h Register", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(LoginActivity.this, "User is not there", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void takeUserToRegisterPage(View v){
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }
}
