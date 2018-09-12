package com.example.waleed.firebaseauthentication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainMenuActivity extends AppCompatActivity {
FirebaseAuth auth;
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        auth=FirebaseAuth.getInstance();
        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        int incommingId=item.getItemId();
        switch (incommingId){
            case R.id.settings:
                startActivity(new Intent(MainMenuActivity.this,SettingsActivity.class));
                break;
            case R.id.logout:
                // logout on fire base having session
                auth.signOut();
                FirebaseAuth.AuthStateListener authStateListener=new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        firebaseUser=firebaseAuth.getCurrentUser();
                        if(firebaseUser==null){
                        startActivity(new Intent(MainMenuActivity.this,LoginActivity.class));
                        finish();
                        }
                    }
                };

                break;
        }
        return true;
    }
}
