package com.ohj4.kasvit;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String TAG = "RecyclerAdapter";

    private ArrayList<Plant> plantsList;
    private Context context;

    public RecyclerAdapter(Context context, ArrayList<Plant> plantsList) {
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

        String nameText = plantsList.get(position).getName();

        holder.plantName.setText(nameText);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + nameText);
            }
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