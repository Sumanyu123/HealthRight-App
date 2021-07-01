package com.example.healthright.shop;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthright.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class shop_adapter extends RecyclerView.Adapter<shop_viewholder> {
    ArrayList<shop_model> products;
    Context mcontext;

    public shop_adapter(ArrayList<shop_model> products, Context context) {
        this.products = products;
        mcontext = context;
    }

    @NonNull
    @NotNull
    @Override
    public shop_viewholder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_grid_shop, parent, false);
        return new shop_viewholder(view);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull @NotNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull shop_viewholder holder, int position) {
        holder.img.setImageResource(products.get(position).getImg_name());

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(String.valueOf(products.get(position).getwebsite())));
                mcontext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
