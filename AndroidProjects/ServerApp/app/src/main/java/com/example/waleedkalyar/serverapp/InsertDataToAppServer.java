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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class InsertDataToAppServer extends AppCompatActivity {
EditText edtTxtName,edtTxtEMail,edtTxtPass,edtTxtAdress;
    Button btnSignUp,btnGetUsers;
    String pName,pEMail,pPass,pAdress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data_to_app_server);
        edtTxtName=(EditText) findViewById(R.id.edttxt_p_name);
        edtTxtEMail=(EditText) findViewById(R.id.edttxt_p_e_mail);
        edtTxtPass=(EditText) findViewById(R.id.edttxt_p_password);
        edtTxtAdress=(EditText) findViewById(R.id.edttxt_p_adress);
        btnSignUp=(Button) findViewById(R.id.btn_signup);
        btnGetUsers=(Button) findViewById(R.id.btn_get_users);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pName=edtTxtName.getText().toString();
                pEMail=edtTxtEMail.getText().toString();
                pPass=edtTxtPass.getText().toString();
                pAdress=edtTxtAdress.getText().toString();
                if(pName.isEmpty()||pEMail.isEmpty()||pPass.isEmpty()||pAdress.isEmpty()){
                    Toast.makeText(InsertDataToAppServer.this, "Plese fill the form first", Toast.LENGTH_SHORT).show();
                }
                else{
                    insertNewUser(pName,pEMail,pPass,pAdress);


                }
            }
        });
        btnGetUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //here we code for recive data from xampp
                bringTheServerResponce();
            }
        });
    }
    public void insertNewUser(final String name, final String eMail, final String password, final String adress){
        StringRequest mStringRequest=new StringRequest(1, getApplicationContext().getResources().getString(R.string.insert_new_user_url), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(InsertDataToAppServer.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(InsertDataToAppServer.this, "Server side error!", Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params=new HashMap<>();
                params.put("PersonName",name);
                params.put("PersonE_mail",eMail);
                params.put("PersonPass",password);
                params.put("PersonAdress",adress);
                return params;
            }
        };
        RequestQueue mRequestQue= Volley.newRequestQueue(InsertDataToAppServer.this);
        mRequestQue.add(mStringRequest);
    }


    public void bringTheServerResponce(){
         StringRequest myStringRequest = new StringRequest(1, getApplicationContext().getResources().getString(R.string.get_users_connection_url), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(InsertDataToAppServer.this, response, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject mJSONObject=new JSONObject(response);
                    JSONArray resultArray=mJSONObject.getJSONArray("result");
                    int lengthOfArrayLength=resultArray.length();
                    for(int i=0;i<lengthOfArrayLength;i++){
                        JSONObject incommingJSONObject=resultArray.getJSONObject(i);
                        String pName=incommingJSONObject.getString("Name");
                        String pEMail=incommingJSONObject.getString("E_mail");
                        String pPass=incommingJSONObject.getString("Password");
                        String pAdress=incommingJSONObject.getString("Adress");
                        String personDetail= pName+"     "+pEMail+"     "+pPass+"     "+pAdress;
                        Toast.makeText(InsertDataToAppServer.this,personDetail , Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(InsertDataToAppServer.this, "The server is not Responcing! try again Or \t Chack Network Connection", Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue mRequestQue=Volley.newRequestQueue(InsertDataToAppServer.this);
        mRequestQue.add(myStringRequest);
    }
}
