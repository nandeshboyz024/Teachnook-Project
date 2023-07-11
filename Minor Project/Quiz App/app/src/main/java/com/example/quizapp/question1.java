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

public class question1 extends AppCompatActivity {
    TextView receiveing ;
    TextView score0;
    RadioGroup myRadioGroup;
    RadioButton commonRadioButton;
    RadioButton Final ,Main,Static,Private;
    Button quit;
    int a;

    Button nextque2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        receiveing = (TextView) findViewById(R.id.welcome);
        score0 =(TextView)findViewById(R.id.score0);

        a = 0;
        Intent i = getIntent();
        String str = i.getStringExtra("key");
        receiveing.setText("Hello " + str);
        score0.setText("Your Score : " + a);

        Final =(RadioButton)findViewById(R.id.Final);
        Main=(RadioButton)findViewById(R.id.Main);
        Static=(RadioButton)findViewById(R.id.Static);
        Private=(RadioButton)findViewById(R.id.Private);

        myRadioGroup =(RadioGroup)findViewById(R.id.RadioGroup);
        nextque2 =(Button) findViewById(R.id.nextQue2);
        nextque2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = myRadioGroup.getCheckedRadioButtonId();
                commonRadioButton = (RadioButton)findViewById(selectedId);
                if(selectedId == -1) {
                    Toast.makeText(getApplicationContext(),"Please choose a option or quit the quiz",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (selectedId == Main.getId()) {
                      a = a + 1;
                    }
                    Intent startque2 = new Intent(getApplicationContext(),question2.class);
                    startque2.putExtra("Score",a);
                    startActivity(startque2);
                }
            }
        });
        quit =(Button) findViewById(R.id.quit1);
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