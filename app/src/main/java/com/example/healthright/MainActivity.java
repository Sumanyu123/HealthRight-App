package com.example.healthright;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void stepcounter(View view) {
        Intent i = new Intent(this, Stepcounter.class);
        startActivity(i);
    }

    public void workoutage(View view) {
        Intent i = new Intent(this, workout_age.class);
        startActivity(i);
    }

    public void shop(View view) {
        Intent i = new Intent(this, Shop.class);
        startActivity(i);
    }
}