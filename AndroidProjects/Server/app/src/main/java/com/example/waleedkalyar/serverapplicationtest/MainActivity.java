package com.example.waleedkalyar.serverapplicationtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText edtTxtName, edtTxtEMail, edtTxtPass, edtTxtAdress;
    Button btnSignUp, btnGetAllUsers;
    String name, eMail, pass, adress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtName = (EditText) findViewById(R.id.edt_txt_name);
        edtTxtEMail = (EditText) findViewById(R.id.edt_txt_e_mail);
        edtTxtPass = (EditText) findViewById(R.id.edt_txt_password);
        edtTxtAdress = (EditText) findViewById(R.id.edt_txt_adress);
        btnSignUp = (Button) findViewById(R.id.btn_signup);
        btnGetAllUsers = (Button) findViewById(R.id.btn_get_all_users);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edtTxtName.getText().toString();
                eMail = edtTxtEMail.getText().toString();
                pass = edtTxtPass.getText().toString();
                adress = edtTxtAdress.getText().toString();
                if (name.isEmpty() || eMail.isEmpty() || pass.isEmpty() || adress.isEmpty()) {
                    edtTxtName.setError("Not Filled");
                    edtTxtEMail.setError("Not Filled");
                    edtTxtPass.setError("Not Filled");
                    edtTxtAdress.setError("Not Filled");
                } else {
                    // here we will discuss the server dbms features
                    insertNewUser(name, eMail, pass, adress);
                    edtTxtName.setText("");
                    edtTxtEMail.setText("");
                    edtTxtPass.setText("");
                    edtTxtAdress.setText("");
                    startActivity(new Intent(MainActivity.this, LogInActivity.class));
                }
            }
        });

        btnGetAllUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // here code for get users
                getAllRegisterUsers();
            }
        });
    }

    public void insertNewUser(final String pName, final String pEMail, final String pPassword, final String pAdress) {
        StringRequest mStringRequest = new StringRequest(1, getApplicationContext().getResources().getString(R.string.insert_new_user_url), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Server Side Error", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("PersonName", pName);
                params.put("PersonEmail", pEMail);
                params.put("PersonPass", pPassword);
                params.put("PersonAddress", pAdress);
                return params;
            }
        };
        RequestQueue mRequestQue = Volley.newRequestQueue(MainActivity.this);
        mRequestQue.add(mStringRequest);
    }

    public void getAllRegisterUsers() {
        StringRequest mStringRequest = new StringRequest(1, getApplicationContext().getResources().getString(R.string.get_all_registered_user_url), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject mJSONObject = new JSONObject(response);
                    JSONArray resultArray = mJSONObject.getJSONArray("result");
                    int lengthOfArray = resultArray.length();
                    for (int i = 0; i < lengthOfArray; i++) {
                        JSONObject incomingJSONObject = resultArray.getJSONObject(i);
                        String pName = incomingJSONObject.getString("Name");
                        String pEMail = incomingJSONObject.getString("E_mail");
                        String pPass = incomingJSONObject.getString("Password");
                        String pAdress = incomingJSONObject.getString("Adress");

                        String personDetails = pName + "    " + pEMail + "    " + pPass + "    " + pAdress;
                        Toast.makeText(MainActivity.this, personDetails, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "The server is not Responding \t Please Chack Network connection!", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue mRequestQue = Volley.newRequestQueue(MainActivity.this);
        mRequestQue.add(mStringRequest);
    }
}
