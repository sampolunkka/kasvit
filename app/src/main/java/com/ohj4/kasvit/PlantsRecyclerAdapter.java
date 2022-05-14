package com.ohj4.kasvit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class PlantsRecyclerAdapter extends RecyclerView.Adapter<PlantsRecyclerAdapter.ViewHolder> {

    private static final String TAG = "PlantsRecyclerAdapter";

    private ArrayList<Plant> plantsList;
    private Context context;

    public PlantsRecyclerAdapter(Context context, ArrayList<Plant> plantsList) {
        this.plantsList = plantsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Plant plant = plantsList.get(holder.getAdapterPosition());

        holder.plantName.setText(plant.getName());

        holder.parentLayout.setOnClickListener(view -> {
            Log.d(TAG, "onClick: clicked on: " + plant.getName());
            Intent intent = new Intent(context, PlantActivity.class);
            intent.putExtra("plant_name", plant.getName());
            intent.putExtra("plant_desc", plant.getDescription());
            intent.putExtra("INDEX", position);
            intent.putExtra("PLANT", plant);

            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return  plantsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView plantName;
        private ImageView image;
        private RelativeLayout parentLayout;

        public ViewHolder(final View itemView) {
            super(itemView);
            plantName = itemView.findViewById(R.id.plant_name);
            image = itemView.findViewById(R.id.image);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

}