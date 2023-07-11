package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class question2 extends AppCompatActivity {
    TextView score1;
    RadioGroup myRadioGroup ;
    RadioButton commonRadioButton;
    RadioButton Import , This, Catch , Abstract;
    Button nextque3;
    Button quit;
    int a;
    int notFound =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        score1 = (TextView) findViewById(R.id.score1);

        Intent i = getIntent();
        a= i.getIntExtra("Score",notFound);
        score1.setText("Your Score : " + a);

        Import =(RadioButton) findViewById(R.id.Import);
        This=(RadioButton) findViewById(R.id.This);
        Catch =(RadioButton) findViewById(R.id.Catch);
        Abstract =(RadioButton) findViewById(R.id.Abstract);

        myRadioGroup=(RadioGroup) findViewById(R.id.RadioGroup);
        nextque3=(Button) findViewById(R.id.nextQue3);
        nextque3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = myRadioGroup.getCheckedRadioButtonId();
                commonRadioButton = (RadioButton) findViewById(selectedId);
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(),"Please choose a option or quit the quiz",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (selectedId == This.getId()) {
                        a = a + 1;
                    }
                    Intent startque3 = new Intent(getApplicationContext(),question3.class);
                    startque3.putExtra("Score",a);
                    startActivity(startque3);
                }
            }
        });
        quit =(Button) findViewById(R.id.quit2);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(getApplicationContext(),endQuiz.class);
                mainIntent.putExtra("Score",a);
                startActivity(mainIntent);
            }
        });


    }
}