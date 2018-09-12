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

public class SignupActivity extends AppCompatActivity {
EditText edtxtname,edtxtfName,edtxtemail,edtxtadress,edtxtpass;
    String name,fname,email,adress,pass;
    Button btnSignup,getAllUsers;
    DBMS dbms;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbms=new DBMS(SignupActivity.this);
        setContentView(R.layout.activity_signup);
        edtxtname=(EditText) findViewById(R.id.signup_name);
        edtxtfName=(EditText) findViewById(R.id.signup_fname);
        edtxtemail=(EditText) findViewById(R.id.signup_email);
        edtxtadress=(EditText) findViewById(R.id.signup_adress);
        edtxtpass=(EditText) findViewById(R.id.signup_password);
        btnSignup=(Button) findViewById(R.id.btn_signup);
        getAllUsers=(Button) findViewById(R.id.btn_get_users);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=edtxtname.getText().toString();
                fname=edtxtfName.getText().toString();
                email=edtxtemail.getText().toString();
                adress=edtxtadress.getText().toString();
                pass=edtxtpass.getText().toString();
                if(name.isEmpty()||fname.isEmpty()||email.isEmpty()||adress.isEmpty()||pass.isEmpty()){
                    edtxtname.setError("Please Fill");
                    edtxtfName.setError("Please Fill");
                    edtxtemail.setError("Please Fill");
                    edtxtadress.setError("Please Fill");
                    edtxtpass.setError("Please Fill");
                }else{
                    // the work with db is here
                    db=dbms.getWritableDatabase();
                    dbms.insertUserIntoDB(db,name,fname,email,adress,pass);
                    edtxtname.setText("");
                    edtxtfName.setText("");
                    edtxtemail.setText("");
                    edtxtadress.setText("");
                    edtxtpass.setText("");
                    startActivity(new Intent(SignupActivity.this,LoginActivity.class));
                    finish();
                }
            }
        });



        getAllUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=dbms.getReadableDatabase();
                Cursor incommingCursor= dbms.getAllRegisterUsers(db);
                if(incommingCursor==null){
                    Toast.makeText(SignupActivity.this, "No Data In db", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SignupActivity.this, "Data Is In db", Toast.LENGTH_SHORT).show();
                }
                if(incommingCursor.moveToFirst()){
                    do {
                        String user=incommingCursor.getString(0)+"\t" +incommingCursor.getString(1)+"\t"+incommingCursor.getString(2)+"\t"+incommingCursor.getString(3)+"\t"+incommingCursor.getString(4)+"\t";
                        Toast.makeText(SignupActivity.this, user, Toast.LENGTH_SHORT).show();
                    }
                    while (incommingCursor.moveToNext());
                }
            }
        });
    }
}
