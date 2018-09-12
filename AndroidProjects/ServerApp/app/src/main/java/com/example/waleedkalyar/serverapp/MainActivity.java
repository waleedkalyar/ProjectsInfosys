package com.example.waleedkalyar.serverapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bringMeServerResponce(View view) {
        
      //  StringRequest mStringRequest = new StringRequest(Request.Method.Post,);
        StringRequest mStringRequest = new StringRequest(1, getApplicationContext().getResources().getString(R.string.get_users_connection_url), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Server side error", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue mRequestQue = Volley.newRequestQueue(MainActivity.this);
        mRequestQue.add(mStringRequest);
         

    }
}
