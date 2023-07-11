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

public class question4 extends AppCompatActivity {
    TextView score3;
    RadioGroup radioGroup;
    RadioButton commonRadioButton;
    RadioButton opt1, opt2,opt3 , opt4 ;
    Button nextQue5 ;
    Button quit;
    int a;
    int notfound =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        score3 = (TextView) findViewById(R.id.score3);

        Intent i = getIntent();
        a = i.getIntExtra("Score",notfound);
        score3.setText("Your Score : " + a);

        opt1 =(RadioButton) findViewById(R.id.opt1);
        opt2 =(RadioButton) findViewById(R.id.opt2);
        opt3=(RadioButton) findViewById(R.id.opt3);
        opt4 =(RadioButton) findViewById(R.id.opt4);

        radioGroup =(RadioGroup)findViewById(R.id.RadioGroup);
        nextQue5 =(Button) findViewById(R.id.nextQue5);
        nextQue5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                commonRadioButton =(RadioButton) findViewById(selectedId);

                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(),"Please choose a option or quit the quiz",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (selectedId == opt2.getId()) {
                        a = a + 1;
                    }
                    Intent startque5 = new Intent(getApplicationContext(),question5.class);
                    startque5.putExtra("Score",a);
                    startActivity(startque5);
                }
            }
        });
        quit =(Button) findViewById(R.id.quit4);
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