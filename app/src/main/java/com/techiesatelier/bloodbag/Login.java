package com.techiesatelier.bloodbag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    Button register,login;
    EditText etemail, etpassword;

    private FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        getSupportActionBar().hide();

        mAuth = FirebaseAuth.getInstance();


        etemail = findViewById(R.id.emailreg);
        etpassword=findViewById(R.id.passreg);


        register = findViewById(R.id.btnreg);
        login = findViewById(R.id.btnlogin);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Registration.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userlogin();
            }

            private void userlogin() {

                String email= etemail.getText().toString().trim();
                String password= etpassword.getText().toString().trim();


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


                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            FirebaseUser user =FirebaseAuth.getInstance().getCurrentUser();

                            if (user.isEmailVerified()){

                                Intent intent=new Intent(Login.this,MainActivity.class);
                                startActivity(intent);

                            }
                            else {

                                user.sendEmailVerification();

                                Toast.makeText(Login.this,"Check Your Email And Verify!",Toast.LENGTH_LONG).show();

                            }



                        }
                        else {
                            Toast.makeText(Login.this,"Something Went Wrong!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });




            }


        });



    }






}