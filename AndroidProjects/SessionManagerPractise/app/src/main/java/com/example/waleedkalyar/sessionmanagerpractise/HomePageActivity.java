package com.example.waleedkalyar.sessionmanagerpractise;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.waleedkalyar.sessionmanagerpractise.dbmsPkg.DBMS;
import com.example.waleedkalyar.sessionmanagerpractise.sessionPkg.SessionManager;

public class HomePageActivity extends AppCompatActivity {
    FloatingActionButton fab;
SessionManager mSessionManager;
    DBMS dbms;
    SQLiteDatabase db;
    TextView txtVuHomeName,textVuPemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        mSessionManager=new SessionManager(HomePageActivity.this);
        dbms=new DBMS(HomePageActivity.this);
        txtVuHomeName=(TextView) findViewById(R.id.txtvu_home_name);
        textVuPemail=(TextView) findViewById(R.id.txtvu_home_p_email);
        db=dbms.getReadableDatabase();
        Cursor mCursor=dbms.chackUserLogedIn(db,mSessionManager.chackUserInSessionEmail(),mSessionManager.chackUserInSessionPass());
        mCursor.moveToFirst();
        String name=mCursor.getString(0);
        Toast.makeText(HomePageActivity.this, name, Toast.LENGTH_SHORT).show();
        textVuPemail.setText("YOUR E-MAIL IS: "+mSessionManager.chackUserInSessionEmail());
        txtVuHomeName.setText("WE WELCOME MR."+name+" ON HOME SCREEN");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This show no Action now!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int incommingId=item.getItemId();
        switch (incommingId){
            case R.id.opt_menu_search:
                Toast.makeText(this, "Searching is Start!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opt_menu_user:
                Toast.makeText(this, "User data analysis is Start!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opt_menu_settings:
                Toast.makeText(this, "Setting is in progress!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opt_menu_logout:
                View view=txtVuHomeName;
                Snackbar.make(view,"We are logout",Snackbar.LENGTH_LONG).setAction("Action logout",null).show();
                mSessionManager.loginTheUser("","",false);
                startActivity(new Intent(HomePageActivity.this,LoginActivity.class));
                finish();
                break;
        }
        return true;
    }
}
