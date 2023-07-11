package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Information extends AppCompatActivity {
    TextView n_name;
    TextView e_email;
    TextView back;
    String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        n_name =(TextView) findViewById(R.id.n_name);
        e_email=(TextView) findViewById(R.id.e_email);
        back =(TextView)findViewById(R.id.back);

        Intent i = getIntent();
        s1=i.getStringExtra("Key_name");
        s2=i.getStringExtra("Key_email");
        n_name.setText(s1);
        e_email.setText(s2);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("Key_name",s1);
                i.putExtra("Key_email",s2);
                startActivity(i);
            }
        });
    }
}