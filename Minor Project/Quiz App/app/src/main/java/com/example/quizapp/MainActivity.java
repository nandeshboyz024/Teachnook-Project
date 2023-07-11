package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quizapp.R.id;

public class MainActivity extends AppCompatActivity {
   Button startButton;
   Button aboutButton ;
   EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(id.nameId);
        startButton= (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString().trim();
            if(name.isEmpty() || name.length() ==0 || name.equals("") || name == null)  {
                Toast.makeText(getApplicationContext(),"First Enter Your Name to Start a Quiz",Toast.LENGTH_LONG).show();
            }
            else {
                Intent startque1 = new Intent(getApplicationContext(),question1.class);
                startque1.putExtra("key",name);
                startActivity(startque1);
            }

            }
        });
        aboutButton = (Button)findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutIntent = new Intent(getApplicationContext(),aboutActivity.class);
                startActivity(aboutIntent);

            }
        });
    }
}