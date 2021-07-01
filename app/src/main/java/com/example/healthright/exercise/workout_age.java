package com.example.healthright.exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.healthright.R;
import com.example.healthright.exercise.above70;
import com.example.healthright.exercise.below70;

public class workout_age extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_workout_age);
    }

    public void startforbelow70(View view) {
        Intent i = new Intent(this, below70.class);
        startActivity(i);
    }

    public void startforabove70(View view) {
        Intent i = new Intent(this, above70.class);
        startActivity(i);
    }
}