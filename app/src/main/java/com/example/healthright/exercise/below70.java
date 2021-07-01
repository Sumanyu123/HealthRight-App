package com.example.healthright.exercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.healthright.R;

import java.util.ArrayList;

public class below70 extends AppCompatActivity {
    RecyclerView recyclerView;
    com.example.healthright.exercise.adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_below70);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewB);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new adapter(data());
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<model> data() {
        ArrayList<model> holder = new ArrayList<>();

        model exercise1 = new model();
        exercise1.setName("squats");
        exercise1.setDuration("10 times");
        exercise1.setTip("Use chair for support");
        exercise1.setImg_name(R.drawable.squat_exercise);
        holder.add(exercise1);

        model exercise2 = new model();
        exercise2.setName("hindu pushups");
        exercise2.setDuration("10 times");
        exercise2.setTip("keeping the elbows close to your body, breathe in and out");
        exercise2.setImg_name(R.drawable.hindu_pushups);
        holder.add(exercise2);

        model exercise3 = new model();
        exercise3.setName("bridge");
        exercise3.setDuration("10 times");
        exercise3.setTip("Keep a Pillow under your body");
        exercise3.setImg_name(R.drawable.advanced_bridge);
        holder.add(exercise3);

        model exercise4 = new model();
        exercise4.setName("calf raise");
        exercise4.setDuration("10 times");
        exercise4.setTip("Raise your heels and breathe out as you squeeze your calves");
        exercise4.setImg_name(R.drawable.calf_raises);
        holder.add(exercise4);

        model exercise5 = new model();
        exercise5.setName("clamshell");
        exercise5.setDuration("10 times");
        exercise5.setTip("Rotate your hip to lift the knee and breathe out");
        exercise5.setImg_name(R.drawable.clamshell);
        holder.add(exercise5);

        model exercise6 = new model();
        exercise6.setName("single leg bridge");
        exercise6.setDuration("10 times");
        exercise6.setTip("Keep a Pillow under your body");
        exercise6.setImg_name(R.drawable.single_leg_bridge);
        holder.add(exercise6);

        model exercise7 = new model();
        exercise7.setName("ab stretch");
        exercise7.setDuration("10 times");
        exercise7.setTip("Lie face down on your mat with your legs straight and your arms in a push up position");
        exercise7.setImg_name(R.drawable.ab_stretch);
        holder.add(exercise7);

        model exercise8 = new model();
        exercise8.setName("catback stretch");
        exercise8.setDuration("10 times");
        exercise8.setTip("Do this movement slowly and don’t bounce between positions");
        exercise8.setImg_name(R.drawable.catback_stretch);
        holder.add(exercise8);

        model exercise9 = new model();
        exercise9.setName("v ups");
        exercise9.setDuration("10 times");
        exercise9.setTip("Breathe in as you lower your arms and legs back to the starting position");
        exercise9.setImg_name(R.drawable.v_ups);
        holder.add(exercise9);

        return holder;
    }

}