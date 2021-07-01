package com.example.healthright;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.graphics.Color.RED;

public class Bmi_result_activity extends AppCompatActivity {

    Button mrecalculatebmi;

    TextView mbmiresultdisplay, mbmicategory, mgender;
    Intent i;
    ImageView mimageview;
    String mbmi, height, weight;
    Float intbmi, intheight, intweight;
    RelativeLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"><font>"));
        getSupportActionBar().setTitle("BMI Result");

        i = getIntent();

        mimageview = findViewById(R.id.imageviewbmi);
        mbmiresultdisplay = findViewById(R.id.bmiresultdisplay);
        mbmicategory = findViewById(R.id.bmicategory);
        mgender = findViewById(R.id.genderdisplaytext);
        mbackground = findViewById(R.id.contentlayout);

        height = i.getStringExtra("height");
        weight = i.getStringExtra("weight");

        //for calculations:
        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        intheight = intheight / 100;
        intbmi = intweight / (intheight * intheight);

        mbmi = Float.toString(intbmi);

        if (intbmi < 16) {
            mbmicategory.setText("SEVERE THINNESS");
            //mbackground.setBackground(RED);
            mimageview.setImageResource(R.drawable.crosss);
        } else if (intbmi < 16.9 && intbmi > 16) {
            mbmicategory.setText("MODERATE THINNESS");
            //mbackground.setBackground(RED);
            mimageview.setImageResource(R.drawable.warning);
        } else if (intbmi < 18.4 && intbmi > 17) {
            mbmicategory.setText("MILD THINNESS");
            //mbackground.setBackground(RED);
            mimageview.setImageResource(R.drawable.warning);
        } else if (intbmi < 25 && intbmi > 18.4) {
            mbmicategory.setText("NORMAL");
            //mbackground.setBackground(Color.RED);
            mimageview.setImageResource(R.drawable.ok);
        } else if (intbmi < 29.4 && intbmi > 25) {
            mbmicategory.setText("OVERWEIGHT");
            //mbackground.setBackground(RED);
            mimageview.setImageResource(R.drawable.warning);
        } else {
            mbmicategory.setText("OBESE");
            //mbackground.setBackground(RED);
            mimageview.setImageResource(R.drawable.crosss);
        }


        mgender.setText(i.getStringExtra("gender"));
        mbmiresultdisplay.setText(mbmi);


        mrecalculatebmi = findViewById(R.id.recalculatebmi);
        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Bmi_result_activity.this, Bmi.class);
                startActivity(i);
                finish();
            }
        });
    }
}