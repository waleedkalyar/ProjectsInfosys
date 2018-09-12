package com.example.waleedkalyar.whatsappbyempty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        switch (id) {
            case R.id.opt_menu_search:
                Toast.makeText(this, "Searching is staart", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opt_menu_settings:
                Toast.makeText(this, "Setting is selected", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    // when click on toolbar items

    public void cameraPress(View v){
        Toast.makeText(this, "Camera", Toast.LENGTH_SHORT).show();
    }
    public void chatPress(View v){
        Toast.makeText(this, "Chat", Toast.LENGTH_SHORT).show();
    }
    public void contectsPress(View v){
        Toast.makeText(this, "Contects", Toast.LENGTH_SHORT).show();
    }
}
