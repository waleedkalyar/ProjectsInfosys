package com.example.waleedkalyar.customlistviewpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.waleedkalyar.customlistviewpractice.CustomInstituteModel.InstituteModel;
import com.example.waleedkalyar.customlistviewpractice.customInstituteAdapter.InstitueAdapter;

public class MainActivity extends AppCompatActivity {
ListView lstvuInstitutes;
    InstitueAdapter instAdapter;
    InstituteModel[] instData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstvuInstitutes=(ListView) findViewById(R.id.main_lstvu_for_user);
        lstvuInstitutes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "This is working properly", Toast.LENGTH_SHORT).show();
            }
        });
        instData=new InstituteModel[]{
                new InstituteModel(R.mipmap.ic_launcher,"PGC","2-Khyabane-sadiq","20000","18"),
                new InstituteModel(R.mipmap.ic_launcher_round, "ILM","Samsher-Town","25000","11"),
                new InstituteModel(R.mipmap.ic_launcher_round, "SUPERIOR","Faislabad road","3000","2"),
                new InstituteModel(R.mipmap.ic_launcher, "LEADER","Near zafrola chowk","4000","4"),
                new InstituteModel(R.mipmap.ic_launcher_round, "READER","Khusab Road","10630","6"),
                new InstituteModel(R.mipmap.ic_launcher, "MERADION","Faislabad road","3457","9"),
                new InstituteModel(R.drawable.pic1, "SNAI","Near zafrola chowk","2345","1"),
                new InstituteModel(R.drawable.pic5, "DAR-E-ARQAM","Stadiom Road","3045","0"),
                new InstituteModel(R.drawable.pic3, "SIT","University Road","1200","1"),
                new InstituteModel(R.drawable.pic6,"COMPRIHENSIVE","Near 47 pull","3045","3")};
        instAdapter=new InstitueAdapter(MainActivity.this,R.layout.dummy_style_for_lstvu,instData);
        lstvuInstitutes.setAdapter(instAdapter);
    }
}
