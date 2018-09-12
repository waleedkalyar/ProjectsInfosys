package com.example.waleedkalyar.menupractise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // we inflate/render the menu file by adding this method
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
// All the clicklistners of menus items callbacks!!! are here in this methods
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int incommingId = item.getItemId();
        switch (incommingId) {
            case R.id.opt_menu_search:
                Toast.makeText(this, "SEARCH", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opt_menu_user:
                Toast.makeText(this, "USER", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opt_menu_settings:
                Toast.makeText(this, "SETTINGS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.opt_menu_logout:
                Toast.makeText(this, "LOGOUT", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
