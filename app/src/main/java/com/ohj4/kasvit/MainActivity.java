package com.ohj4.kasvit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<Plant> plantsList;
    private RecyclerView recyclerView;

    //https://www.youtube.com/watch?v=Vyqz_-sJGFk&ab_channel=CodingWithMitch

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");
        //hide action bar
        getSupportActionBar().hide();


        //recyclerView = findViewById(R.id.recycler_view);
        plantsList = new ArrayList<Plant>();

        SetPlantInfo();
        initRecyclerView();
    }

    public void addPlant(View view) {
        /*plantsList.add(new Plant());
        adapter.notifyItemInserted(plantsList.size()-1);*/
        Intent myIntent = new Intent(MainActivity.this, PlantView.class);
        //myIntent.putExtra()
        MainActivity.this.startActivity(myIntent);
    }

    public void openPlantView(View view) {
        Intent myIntent = new Intent(MainActivity.this, PlantView.class);
        MainActivity.this.startActivity(myIntent);
    }

    private void SetPlantInfo() {

        plantsList.add(new Plant("lol"));
        plantsList.add(new Plant("Janne"));

    }
/*
    private void setAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(plantsList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        this.adapter = adapter;
    }
    */

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerAdapter adapter = new RecyclerAdapter(this, plantsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}