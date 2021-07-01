package com.example.healthright.shop;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthright.R;

import org.jetbrains.annotations.NotNull;

//for holding the reference of xml views
public class shop_viewholder extends RecyclerView.ViewHolder {
    ImageView img;

    public shop_viewholder(@NonNull @NotNull View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.product_img);
    }
}
