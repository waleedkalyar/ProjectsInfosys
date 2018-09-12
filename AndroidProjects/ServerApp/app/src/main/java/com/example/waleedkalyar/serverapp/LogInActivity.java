package com.example.waleedkalyar.serverapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
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

import java.util.HashMap;
import java.util.Map;

public class LogInActivity extends AppCompatActivity {
    EditText edtLogEmail, edtLogPass;
    Button btnLogIn;
    String pEMail, pPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        edtLogEmail = (EditText) findViewById(R.id.edt_txt_login_email);
        edtLogPass = (EditText) findViewById(R.id.edt_txt_login_pass);
        btnLogIn = (Button) findViewById(R.id.btn_login);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pEMail = edtLogEmail.getText().toString();
                pPass = edtLogPass.getText().toString();
                if (pEMail.isEmpty() || pPass.isEmpty()) {
                    edtLogEmail.setError("Please fill");
                    edtLogPass.setError("Please fill");
                } else {
                    // here we make logic for login
                    chackForLogIn(pEMail, pPass);
                }
            }
        });
    }

    public void textClickResponce(View view) {
        startActivity(new Intent(LogInActivity.this, InsertDataToAppServer.class));

    }

    public void chackForLogIn(final String eMail, final String password) {
        StringRequest mStringRequest = new StringRequest(1, getApplicationContext().getResources().getString(R.string.chack_login_new_user_url), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals(true)) {
                    Toast.makeText(LogInActivity.this, "You are successfully registered", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LogInActivity.this, "Please register yourself first", Toast.LENGTH_SHORT).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LogInActivity.this, "The server is not Responding\t please chack Network connection", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("PersonEmail", eMail);
                params.put("PersonPass", password);
                return params;
            }
        };
        RequestQueue mRequestQue = Volley.newRequestQueue(LogInActivity.this);
        mRequestQue.add(mStringRequest);
    }
}













