package com.example.waleed.volleywithgsonpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.waleed.volleywithgsonpractice.adapters.UserProfilesMenuAdapter;
import com.example.waleed.volleywithgsonpractice.models.GitHubUsersModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private Gson gson;
private RecyclerView mRecyclerView;
private UserProfilesMenuAdapter menuAdapter;
List<GitHubUsersModel> usersModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView) findViewById(R.id.mRecyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        usersModels=new ArrayList<>();
        GsonBuilder gsonBuilder=new GsonBuilder();
       // gsonBuilder.setDateFormat("M/d/yy hh:mm:a");
        String url="https://api.github.com/users?since=135.php";
        gson=gsonBuilder.create();


        StringRequest mFetchDataStringReuest=new StringRequest(Request.Method.GET,url , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONArray jsonArray=null;
                try {

                    jsonArray=new JSONArray(response);
                    for (int i=0;i<jsonArray.length();i++){
                        GitHubUsersModel usersModel=gson.fromJson(jsonArray.get(i).toString(),GitHubUsersModel.class);
                       // Toast.makeText(MainActivity.this, usersModel.getLogin(), Toast.LENGTH_SHORT).show();
                        usersModels.add(usersModel);


                    }
                    //Toast.makeText(MainActivity.this, usersModels.get(1).getLogin(), Toast.LENGTH_SHORT).show();
                    menuAdapter =new UserProfilesMenuAdapter(usersModels);
                    mRecyclerView.setAdapter(menuAdapter);

                } catch (Exception e){e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Response Not Found! ", Toast.LENGTH_SHORT).show();}

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Request Not Sent!,\n Check URL ", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(mFetchDataStringReuest);


    }
}
