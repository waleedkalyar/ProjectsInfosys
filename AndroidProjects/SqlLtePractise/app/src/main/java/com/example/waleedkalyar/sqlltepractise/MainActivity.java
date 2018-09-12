package com.example.waleedkalyar.sqlltepractise;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.util.LogWriter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.waleedkalyar.sqlltepractise.dbmsPkg.DBMS;

public class MainActivity extends AppCompatActivity {
    EditText edtTxtName, edtTxtFName, edtTxtPass, edtTxtAdress;
    Button btnRegister,btnGetAllUsers;
    String name, fName, pass, adress;
    //our custom database manager is hers
    DBMS dbms;
    // helper to close or open the db
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbms = new DBMS(MainActivity.this);
        edtTxtName = (EditText) findViewById(R.id.edt_txt_name);
        edtTxtFName = (EditText) findViewById(R.id.edt_txt_fname);
        edtTxtPass = (EditText) findViewById(R.id.edt_txt_password);
        edtTxtAdress = (EditText) findViewById(R.id.edt_txt_adress);
        btnRegister = (Button) findViewById(R.id.btn_register_me);
        btnGetAllUsers = (Button) findViewById(R.id.btn_get_all_users);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edtTxtName.getText().toString();
                fName = edtTxtFName.getText().toString();
                pass = edtTxtPass.getText().toString();
                adress = edtTxtAdress.getText().toString();
               /* if (name.isEmpty()||fName.isEmpty()||pass.isEmpty()||adress.isEmpty()){
                    edtTxtName.setError("Form Not Filled");
                    edtTxtFName.setError("Form Not Filled");
                    edtTxtPass.setError("Form Not Filled");
                    edtTxtAdress.setError("Form Not Filled");
                }*/
                if (name.isEmpty())
                    edtTxtName.setError("Person Name Not Filled");
                if (fName.isEmpty())
                    edtTxtFName.setError("Father Name Not Filled");
                if (pass.isEmpty())
                    edtTxtPass.setError("Password Not Filled");
                if (adress.isEmpty())
                    edtTxtAdress.setError("Adress Not Filled");
                else {
                    // here we will use the DBMS features
                    db = dbms.getWritableDatabase();
                    dbms.insertNewUserIntoDb(db,name,fName,pass,adress);
                    edtTxtName.setText("");
                    edtTxtFName.setText("");
                    edtTxtPass.setText("");
                    edtTxtAdress.setText("");
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                    finish();

                }
            }
        });
                btnGetAllUsers.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        db=dbms.getReadableDatabase();
                      Cursor incommingCursor=  dbms.getAllRegisterUsers(db);
                        if(incommingCursor==null){
                            Toast.makeText(MainActivity.this, "No Data In db", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Data Is In db", Toast.LENGTH_SHORT).show();
                        }
                        if(incommingCursor.moveToFirst()){
                            do {
                                String user=incommingCursor.getString(0)+"\t" +incommingCursor.getString(1)+"\t"+incommingCursor.getString(2)+"\t"+incommingCursor.getString(3)+"\t";
                                Toast.makeText(MainActivity.this, user, Toast.LENGTH_SHORT).show();
                            }
                            while (incommingCursor.moveToNext());
                        }
                    }
                });

    }
}
