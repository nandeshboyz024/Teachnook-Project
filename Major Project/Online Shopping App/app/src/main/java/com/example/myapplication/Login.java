package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText email,password;
    Button login;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.email);
        password =(EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

        databaseHelper = new DatabaseHelper(Login.this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_email=email.getText().toString().trim();
                String user_password = password.getText().toString().trim();
                if(!databaseHelper.checkUser(user_email)){
                    Toast.makeText(Login.this, "Email does not exists", Toast.LENGTH_SHORT).show();
                }
                else if (!databaseHelper.checkUserData(user_email,user_password)){
                    Toast.makeText(Login.this, "Password does not match", Toast.LENGTH_SHORT).show();
                }
                else{
                    String row = databaseHelper.findUserName(user_email,user_password);


                        // Toast.makeText(Login.this,row, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    intent.putExtra("Key_name",row);
                    intent.putExtra("Key_email",user_email);

                    startActivity(intent);

                     }

                }

        });




    }
}