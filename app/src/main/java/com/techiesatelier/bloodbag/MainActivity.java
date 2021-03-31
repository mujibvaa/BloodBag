package com.techiesatelier.bloodbag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button donate,request,search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().hide();


        donate = findViewById(R.id.btdonate);
        request=findViewById(R.id.btrequest);
        search = findViewById(R.id.btsearch);


        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent indonate = new Intent(MainActivity.this,Registration.class);
                startActivity(indonate);
            }
        });



        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent insearch = new Intent(MainActivity.this, Groups.class);
                startActivity(insearch);
            }
        });






    }
}