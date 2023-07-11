package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class Registration extends AppCompatActivity {

    TextInputLayout l1,l2,l3,l4;
    EditText name,email,password,cPassword;
    Button btn;
    TextView exist;
    String s1,s2;

    private  InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        l1 = (TextInputLayout) findViewById(R.id.l1);
        l2 = (TextInputLayout) findViewById(R.id.l2);
        l3 = (TextInputLayout) findViewById(R.id.l3);
        l4 = (TextInputLayout) findViewById(R.id.l4);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        cPassword = (EditText) findViewById(R.id.cPassword);

        btn = (Button) findViewById(R.id.btn);
        exist =(TextView) findViewById(R.id.exist);

       databaseHelper = new DatabaseHelper(Registration.this);
        inputValidation = new InputValidation(Registration.this);

        user = new User();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!inputValidation.IsInputEditTextFilled(name,l1,"Enter Full Name")){
                    return;
                }
                if(!inputValidation.IsInputEditTextFilled(email,l2,"Enter A Valid Email")){
                    return;
                }
                if(!inputValidation.IsInputEditTextEmail(email,l2,"Enter A Valid Email")){
                    return;
                }
                if(!inputValidation.IsInputEditTextFilled(password,l3,"Enter Password")){
                    return;
                }
                if(!inputValidation.IsInputEditTextMatches(password,cPassword,l4,"Password Does Not Match")){
                    return;
                }
                s1 =name.getText().toString().trim();
                s2=email.getText().toString().trim();
                if(!databaseHelper.checkUser(email.getText().toString().trim())){
                   user.setName(s1);
                   user.setEmail(s2);
                   user.setPassword(password.getText().toString().trim());
                   databaseHelper.addUser(user);
                   name.getText().clear();
                    email.getText().clear();
                    password.getText().clear();
                    cPassword.getText().clear();

                    Toast.makeText(Registration.this, "Registration Successful", Toast.LENGTH_SHORT).show();


                    Intent i= new Intent(getApplicationContext(),MainActivity.class);
                    i.putExtra("Key_name",s1);
                    i.putExtra("Key_email",s2);

                    startActivity(i);

                }
                else{
                    name.getText().clear();
                    email.getText().clear();
                    password.getText().clear();
                    cPassword.getText().clear();
                    Toast.makeText(Registration.this,"Email Already Exists", Toast.LENGTH_SHORT).show();
                }

            }

        });

        exist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Login.class);
                startActivity(i);
            }
        });



    }


}