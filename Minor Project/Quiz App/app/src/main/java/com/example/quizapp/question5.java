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

public class question5 extends AppCompatActivity {
    TextView score4;
    RadioGroup radioGroup;
    RadioButton commonRadioButton;
    RadioButton opt1, opt2,opt3 , opt4 ;
    Button finalResult;
    Button quit;
    int a;
    int notfound =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        score4 = (TextView) findViewById(R.id.score4);

        Intent i = getIntent();
        a = i.getIntExtra("Score",notfound);
        score4.setText("Your Score : " + a);

        opt1 =(RadioButton) findViewById(R.id.opt1);
        opt2 =(RadioButton) findViewById(R.id.opt2);
        opt3=(RadioButton) findViewById(R.id.opt3);
        opt4 =(RadioButton) findViewById(R.id.opt4);

        radioGroup =(RadioGroup)findViewById(R.id.RadioGroup);
        finalResult =(Button) findViewById(R.id.finalResult);
        finalResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                commonRadioButton =(RadioButton) findViewById(selectedId);

                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(),"Please choose a option or quit the quiz",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (selectedId == opt4.getId()) {
                        a = a + 1;
                    }
                    Intent endIntent = new Intent(getApplicationContext(),endQuiz.class);
                    endIntent.putExtra("Score",a);
                    startActivity(endIntent);
                }
            }
        });

        quit =(Button) findViewById(R.id.quit5);
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