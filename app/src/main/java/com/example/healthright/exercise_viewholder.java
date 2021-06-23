package com.example.healthright;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

//for holding the reference of xml views
public class exercise_viewholder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView t1, t2, t3;

    public exercise_viewholder(@NonNull @NotNull View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.squat_execise);
        t1 = (TextView) itemView.findViewById(R.id.name);
        t2 = (TextView) itemView.findViewById(R.id.duration);
        t3 = (TextView) itemView.findViewById(R.id.tip);
    }
}
