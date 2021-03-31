package com.techiesatelier.bloodbag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class Groups extends AppCompatActivity {

    Button a,ap,b,bp,ab,abp,o,op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);


        getSupportActionBar().hide();



        a= findViewById(R.id.btgan);
        ap= findViewById(R.id.btgap);
        b= findViewById(R.id.btgbn);
        bp= findViewById(R.id.btgbp);
        ab= findViewById(R.id.btgabn);
        abp= findViewById(R.id.btgabp);
        o= findViewById(R.id.btgon);
        op= findViewById(R.id.btgop);



        ap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Groups.this,APossitive.class);
                startActivity(intent);
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentan = new Intent(Groups.this,ANegetive.class);
                startActivity(intentan);
            }
        });



        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Groups.this,BPossitive.class);
                startActivity(intent);
            }
        });

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentan = new Intent(Groups.this,ABNegetive.class);
                startActivity(intentan);
            }
        });



        abp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Groups.this,ABPossitive.class);
                startActivity(intent);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentan = new Intent(Groups.this,BNegetive.class);
                startActivity(intentan);
            }
        });



        op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Groups.this,OPossitive.class);
                startActivity(intent);
            }
        });

        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentan = new Intent(Groups.this,ONegetive.class);
                startActivity(intentan);
            }
        });













    }





}