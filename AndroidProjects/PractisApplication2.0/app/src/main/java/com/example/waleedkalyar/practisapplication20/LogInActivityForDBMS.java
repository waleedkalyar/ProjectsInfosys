package com.example.waleedkalyar.practisapplication20;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.waleedkalyar.practisapplication20.databases.DBMS;

public class LogInActivityForDBMS extends AppCompatActivity {
    EditText edtTxtEMail, edtTxtPass;
    Button btnLogIn;
    String email, password;
    DBMS dbms;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_for_dbms);
        dbms = new DBMS(LogInActivityForDBMS.this);
        edtTxtEMail = (EditText) findViewById(R.id.edt_txt_login_email);
        edtTxtPass = (EditText) findViewById(R.id.edt_txt_login_password);
        btnLogIn = (Button) findViewById(R.id.btn_login);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = edtTxtEMail.getText().toString();
                password = edtTxtPass.getText().toString();
                if (email.isEmpty() || password.isEmpty()) {
                    edtTxtEMail.setError("Please Enter E-Mail First");
                    edtTxtPass.setError("Please Enter Password First");
                } else {
                    db = dbms.getReadableDatabase();
                    Cursor c = dbms.chackUserLogedIn(db, email, password);
                    if(c.getCount()==1){
                        Toast.makeText(LogInActivityForDBMS.this, "You LogIn Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LogInActivityForDBMS.this,ListViewMadeFromCustomAdapter.class));
                    }else{
                        Toast.makeText(LogInActivityForDBMS.this, "Your LogIn Fail\t please register you First", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });
    }

    public void notRegisteredGoToSignUp(View view) {
        startActivity(new Intent(LogInActivityForDBMS.this, DatabaseTest.class));
    }
}
