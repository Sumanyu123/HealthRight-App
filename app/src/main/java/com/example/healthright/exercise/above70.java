package com.example.healthright.exercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.healthright.R;

import java.util.ArrayList;

public class above70 extends AppCompatActivity {

    RecyclerView recyclerView;
    com.example.healthright.exercise.adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_above70);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewA);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new adapter(data());
        recyclerView.setAdapter(adapter);
    }

    public ArrayList<model> data() {
        ArrayList<model> holder = new ArrayList<>();

        model exercise1 = new model();
        exercise1.setName("cross jacks");
        exercise1.setDuration("5 times");
        exercise1.setTip("Maintain balance and move slowly");
        exercise1.setImg_name(R.drawable.cross_jacks);
        holder.add(exercise1);

        model exercise2 = new model();
        exercise2.setName("leg raise");
        exercise2.setDuration("10 times");
        exercise2.setTip("raise legs slowly as high as you can");
        exercise2.setImg_name(R.drawable.straight_leg_raise);
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

        return holder;
    }
}