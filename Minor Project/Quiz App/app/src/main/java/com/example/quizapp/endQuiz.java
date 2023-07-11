package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class endQuiz extends AppCompatActivity {
    TextView textview1;
    TextView textview2;
    TextView textview3;
    Button restart;
    int a;
    int notFound =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_quiz);
        textview1 = (TextView) findViewById(R.id.textview1);
        textview2 = (TextView) findViewById(R.id.textview2);
        textview3 =(TextView) findViewById(R.id.textview3);

        Intent i = getIntent();
        a = i.getIntExtra("Score",notFound);
        textview1.setText("Correct Answers : " + a);
        int b = 5-a;
        textview2.setText("Wrong Answers : " + b);
        textview3.setText("Final Score : " + a);

        restart =(Button) findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mainIntent);
            }
        });

    }
}