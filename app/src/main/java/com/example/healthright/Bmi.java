package com.example.healthright;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Bmi extends AppCompatActivity {

    Button mcalculatebmi;
    TextView mcurrentheight, mcurrentage, mcurrentweight;
    ImageView mincrementage, mdecrementage, mincrementweight, mdecrementweight;
    SeekBar mseekbarforheight;
    RelativeLayout mmale, mfemale;

    int intweight = 55, intage = 20, currentprogress;
    String mintprogress = "174", typeofuser = "0", weight2 = "55", age2 = "20";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        mcalculatebmi = findViewById(R.id.calculatebmi);
        mcurrentage = findViewById(R.id.currentage);
        mcurrentweight = findViewById(R.id.currentweight);
        mcurrentheight = findViewById(R.id.currentheight);
        mincrementage = findViewById(R.id.incrementage);
        mdecrementage = findViewById(R.id.decrementage);
        mincrementweight = findViewById(R.id.incrementweight);
        mdecrementweight = findViewById(R.id.decrementweight);
        mseekbarforheight = findViewById(R.id.seekbarforheight);
        mmale = findViewById(R.id.male);
        mfemale = findViewById(R.id.female);


        //when user clicks on either male gender or female gender:
        mmale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeofuser = "MALE";
            }
        });

        mfemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mfemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalefocus));
                mmale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.malefemalenotfocus));
                typeofuser = "FEMALE";
            }
        });

        mseekbarforheight.setMax(300);
        mseekbarforheight.setProgress(170);
        mseekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress = progress;
                //typecast int progress to string:
                mintprogress = String.valueOf(currentprogress);

                mcurrentheight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        mincrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage + 1;
                //Typecasting again to show int age to string form:
                age2 = String.valueOf(intage);

                mcurrentage.setText(age2);
            }
        });

        mdecrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage = intage - 1;
                //Typecasting again to show int age to string form:
                age2 = String.valueOf(intage);

                mcurrentage.setText(age2);
            }
        });

        mincrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight + 1;
                //Typecasting again to show int weight in string form:
                weight2 = String.valueOf(intweight);

                mcurrentweight.setText(weight2);
            }
        });

        mdecrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight = intweight - 1;
                //Typecasting again to show int weight in string form:
                weight2 = String.valueOf(intweight);

                mcurrentweight.setText(weight2);
            }
        });


        mcalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (typeofuser.equals("0"))
                    Toast.makeText(getApplicationContext(), "Select Gender", Toast.LENGTH_SHORT).show();
                else if (mintprogress.equals("0"))
                    Toast.makeText(getApplicationContext(), "Select Height", Toast.LENGTH_SHORT).show();
                else if (intage == 0 || intage < 0)
                    Toast.makeText(getApplicationContext(), "Age is incorrect", Toast.LENGTH_SHORT).show();
                else if (intweight == 0 || intweight < 0)
                    Toast.makeText(getApplicationContext(), "Weight is incorrect", Toast.LENGTH_SHORT).show();
                else {
                    Intent i = new Intent(Bmi.this, Bmi_result_activity.class);
                    i.putExtra("gender", typeofuser);
                    i.putExtra("height", mintprogress);
                    i.putExtra("weight", weight2);
                    i.putExtra("age", age2);
                    startActivity(i);
                }
            }
        });
    }
}