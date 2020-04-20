package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.userPhotos;
import com.squareup.picasso.Picasso;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.MyViewHolder>{
    Context context;
    com.example.myapplication.models.userPhotos userPhotos;


    public PhotoAdapter(Context context, com.example.myapplication.models.userPhotos userPhotos) {
        this.context = context;
        this.userPhotos = userPhotos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Picasso.get()
                .load(userPhotos.get(position).getUrl())
                .into(holder.photo);
        holder.title.setText(userPhotos.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return userPhotos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView photo;
        TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
        }
    }
}
