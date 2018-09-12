package com.example.waleedkalyar.mytestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.onClick;
import static android.R.attr.webTextViewStyle;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText edtTxt;
    TextView txtView;
    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practise_me);
        edtTxt = (EditText) findViewById(R.id.editTxt_test);
        button = (Button) findViewById(R.id.testbutton);
        txtView = (TextView) findViewById(R.id.txtview_test);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new space ctrl+space+enter;
            }
        });
    }


    public void onClickListner(View view) {
        Toast.makeText(this,"Yeh! it is working properly", Toast.LENGTH_SHORT).show();
  txtView.setText(edtTxt.getText().toString());
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("Person",edtTxt.getText().toString());
        startActivity(intent);
        //finish();
        //button.setText(edttxt.getText().toString());
    }
    //  public void testMethod(View v){
//edttxt.getText().toString(); is ko nechy wali string me likhny se edt_txt Toast bn jay ga!!!
    //    Toast.makeText(this, edttxt.getText().toString(), Toast.LENGTH_SHORT).show();
    //  }
}


