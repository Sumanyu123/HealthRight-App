package com.example.healthright;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<exercise_viewholder> {
    ArrayList<model> exercises_b;

    public adapter(ArrayList<model> exercises_b) {
        this.exercises_b = exercises_b;
    }

    @NonNull
    @NotNull
    @Override
    public exercise_viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_row, parent, false);
        return new exercise_viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull exercise_viewholder holder, int position) {
        holder.t1.setText(exercises_b.get(position).getName());
        holder.t2.setText(exercises_b.get(position).getDuration());
        holder.t3.setText(exercises_b.get(position).getTip());
        holder.img.setImageResource(exercises_b.get(position).getImg_name());
    }

    @Override
    public int getItemCount() {
        return exercises_b.size();
    }
}
