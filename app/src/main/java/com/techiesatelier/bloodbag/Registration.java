package com.techiesatelier.bloodbag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {

    EditText etname, etage, etphone, etemail, etpassword;
    Spinner bloodgroup, donnercity;
    Button register,login;



    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();



        etname = findViewById(R.id.namereg);
        etage = findViewById(R.id.agereg);
        etphone = findViewById(R.id.phonereg);
        etemail = findViewById(R.id.emailreg);
        etpassword=findViewById(R.id.passreg);

        bloodgroup = findViewById(R.id.bloodgroupreg);
        donnercity=findViewById(R.id.cityreg);

        register = findViewById(R.id.btnreg);
        login = findViewById(R.id.btnlogin);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this,Login.class);
                startActivity(intent);
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registeruser();
            }
        });




    }


    private void registeruser(){


        String name= etname.getText().toString().trim();
        String age= etage.getText().toString().trim();
        String phone= etphone.getText().toString().trim();
        String email= etemail.getText().toString().trim();
        String password= etpassword.getText().toString().trim();
        String group = bloodgroup.getSelectedItem().toString().trim();
        String city = donnercity.getSelectedItem().toString().trim();


        if (name.isEmpty()){
            etname.setError("Full Name Is Required !");
            etname.requestFocus();
            return;
        }

        if (age.isEmpty()){
            etage.setError("Age Is Required !");
            etage.requestFocus();
            return;
        }

        if (phone.isEmpty()){
            etphone.setError("Number Is Required !");
            etphone.requestFocus();
            return;
        }
        if (email.isEmpty()){
            etemail.setError("Email Is Required !");
            etemail.requestFocus();
            return;
        }

        if (password.isEmpty()){
            etpassword.setError("Password Is Required !");
            etpassword.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            etemail.setError("Valid Email Is Required !");
            etemail.requestFocus();
            return;

        }

        if (password.length() <6){
            etpassword.setError("Strong Password Required !");
            etpassword.requestFocus();
            return;

        }




        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            User user = new User(name,age,phone,email,group,city);


                            FirebaseDatabase.getInstance().getReference(group)
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(Registration.this,"Successful",Toast.LENGTH_SHORT).show();
                                        etname.setText("");
                                        etage.setText("");
                                        etphone.setText("");
                                        etemail.setText("");
                                        etpassword.setText("");
                                        Intent intent = new Intent(Registration.this,Login.class);
                                    }
                                    else {
                                        Toast.makeText(Registration.this,"Registration Failed!",Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });


                        }
                        else {
                            Toast.makeText(Registration.this,"Registration Failed!",Toast.LENGTH_SHORT).show();

                        }
                    }
                });



    }


}


