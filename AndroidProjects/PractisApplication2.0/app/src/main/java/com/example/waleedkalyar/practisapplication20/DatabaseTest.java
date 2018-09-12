package com.example.waleedkalyar.practisapplication20;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.waleedkalyar.practisapplication20.databases.DBMS;

public class DatabaseTest extends AppCompatActivity {
EditText name,eMail,password,adress;
    Button btnRegisterMe,btnGetAllUsers;
    public DBMS dbms;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_test);
        dbms=new DBMS(DatabaseTest.this);
        name=(EditText) findViewById(R.id.editText_name);
        eMail=(EditText) findViewById(R.id.editText_e_mail);
        password=(EditText) findViewById(R.id.editText_password);
        adress=(EditText) findViewById(R.id.editText_adress);
        btnRegisterMe=(Button) findViewById(R.id.btn_register_me);
        btnGetAllUsers=(Button) findViewById(R.id.btn_get_all_users);
        btnRegisterMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pName = name.getText().toString();
                String pEMail = eMail.getText().toString();
                String pPass = password.getText().toString();
                String pAdress = adress.getText().toString();
                if (pName.isEmpty())
                    name.setError("Name Not Entered");
               if (pEMail.isEmpty())
                    eMail.setError("E-Mail Not Entered");
                if (pPass.isEmpty())
                    password.setError("Password Not Entered");
                    if (pAdress.isEmpty())
                    adress.setError("Adress Not Entered");
                else {
                    db = dbms.getWritableDatabase();
                    dbms.addUserDetailsIntoDb(db,pName,pEMail,pPass,pAdress);
                    name.setText("");
                    eMail.setText("");
                    password.setText("");
                    adress.setText("");
                }
            }
        });
        btnGetAllUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=dbms.getReadableDatabase();
                Cursor incommingCursor= dbms.getAllUsersDataFromDb(db);
                if(incommingCursor==null)
                    Toast.makeText(DatabaseTest.this, "The db is empty", Toast.LENGTH_SHORT).show();
                else{
                    Toast.makeText(DatabaseTest.this, "The db Has Data", Toast.LENGTH_SHORT).show();}
                    if(incommingCursor.moveToFirst()) {
                        do {
                            String user = incommingCursor.getString(0) + "\t" + incommingCursor.getString(1) + "\t" + incommingCursor.getString(2) + "\t" + incommingCursor.getString(3);
                            Toast.makeText(DatabaseTest.this, user, Toast.LENGTH_SHORT).show();
                        }
                        while (incommingCursor.moveToNext());
                    }
            }
        });
    }
}
