package com.example.csit551gpacal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn_return;
    Button CALCULATE;
    EditText sbj1,sbj2,sbj3,sbj4,sbj5,total,ave;
    double  g1,g2,g3,g4,g5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Move to Activity code , I just using that reset system!!
       btn_return = findViewById(R.id.btn_return);
       btn_return.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, MainActivity.class);
               startActivity(intent);
           }
       });
        // Insert Subjects grade score and calculator total grade and average
        sbj1=(EditText) findViewById(R.id.et_sb1);
        sbj2=(EditText) findViewById(R.id.et_sb2);
        sbj3=(EditText) findViewById(R.id.et_sb3);
        sbj4=(EditText) findViewById(R.id.et_sb4);
        sbj5=(EditText) findViewById(R.id.et_sb5);
        total=(EditText) findViewById(R.id.et_total);
        ave=(EditText) findViewById(R.id.et_ave);
        CALCULATE=(Button) findViewById(R.id.btn_result);
        CALCULATE.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                double g1=Double.parseDouble(sbj1.getText().toString());
                double g2=Double.parseDouble(sbj2.getText().toString());
                double g3=Double.parseDouble(sbj3.getText().toString());
                double g4=Double.parseDouble(sbj4.getText().toString());
                double g5=Double.parseDouble(sbj5.getText().toString());

                //Total grade and Average calculate!!

                double totalGrade = g1+g2+g3+g4+g5;
                int numSubjects = 5;
                double average = totalGrade/numSubjects;

               total.setText(String.valueOf(totalGrade));
                ave.setText(String.valueOf(average));

                if (average < 60) {
                    //Background color is red by average Grade is under 60.
                    findViewById(R.id.activity_main).setBackgroundColor(0XFFFF0000);

                }else if (average >= 61 && average <= 79) {
                    //Background color is yellow by average Grade is 61 between 79.
                    findViewById(R.id.activity_main).setBackgroundColor(0XFFFFFF00);

                }else {
                    // Background color is Green by average grade is over 80.
                    findViewById(R.id.activity_main).setBackgroundColor(0XFF00FF00);
                }



            }
        });
    }

}