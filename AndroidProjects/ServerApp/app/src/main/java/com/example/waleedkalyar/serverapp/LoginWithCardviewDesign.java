package com.example.waleedkalyar.serverapp;

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

import java.util.HashMap;
import java.util.Map;

public class LoginWithCardviewDesign extends AppCompatActivity {
EditText cardLogEmail,cardLogPass;
    String email,password;
    Button btnSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_cardview_design);
        cardLogEmail=(EditText) findViewById(R.id.cardview_login_edttxt_email);
        cardLogPass=(EditText) findViewById(R.id.cardview_login_edttxt_pass);
        btnSignin=(Button) findViewById(R.id.cardview_login_btn_signin);
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=cardLogEmail.getText().toString();
                password=cardLogPass.getText().toString();
                if(email.isEmpty()||password.isEmpty()){
                    cardLogEmail.setError("Not filled");
                    cardLogPass.setError("Not filled");
                }else{
                    StringRequest mStringRequest=new StringRequest(1, getApplicationContext().getResources().getString(R.string.chack_for_login2_user_url), new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(LoginWithCardviewDesign.this, response, Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(LoginWithCardviewDesign.this, "Server side Error", Toast.LENGTH_SHORT).show();

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params=new HashMap<>();
                            params.put("E_mail",email);
                            params.put("Password",password);
                            return params;
                        }
                    };
                    RequestQueue mRequestQue= Volley.newRequestQueue(LoginWithCardviewDesign.this);
                    mRequestQue.add(mStringRequest);
                }
            }
        });
    }
}
