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

public class question3 extends AppCompatActivity {
   TextView score2;
   RadioGroup radioGroup;
   RadioButton commonRadioButton;
   RadioButton Public, Protected, Private , AllOfThese ;
   Button nextQue4 ;
   Button quit;
   int a;
   int notfound =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        score2 = (TextView) findViewById(R.id.score2);

        Intent i = getIntent();
        a = i.getIntExtra("Score",notfound);
        score2.setText("Your Score : " + a);

        Public =(RadioButton) findViewById(R.id.Public);
        Protected =(RadioButton) findViewById(R.id.Protected);
        Private=(RadioButton) findViewById(R.id.Private);
        AllOfThese =(RadioButton) findViewById(R.id.AllOfThese);

        radioGroup =(RadioGroup)findViewById(R.id.RadioGroup);
        nextQue4 =(Button) findViewById(R.id.nextQue4);
        nextQue4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                commonRadioButton =(RadioButton) findViewById(selectedId);

                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(),"Please choose a option or quit the quiz",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (selectedId == Public.getId()) {
                        a = a + 1;
                    }
                    Intent startque4 = new Intent(getApplicationContext(),question4.class);
                    startque4.putExtra("Score",a);
                    startActivity(startque4);
                }
            }
        });
        quit =(Button) findViewById(R.id.quit3);
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