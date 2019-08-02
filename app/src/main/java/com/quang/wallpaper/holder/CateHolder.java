package com.quang.wallpaper.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.quang.wallpaper.R;

 public class CateHolder extends RecyclerView.ViewHolder {

    public TextView tvSlug;
     public TextView tvCout;
     public ImageView imageView;
    public CateHolder(@NonNull View itemView) {
        super(itemView);
        tvSlug = itemView.findViewById(R.id.tvSlug_Category);
        tvCout = itemView.findViewById(R.id.tvCout_Category);
        imageView = itemView.findViewById(R.id.imageView);
    }
}
