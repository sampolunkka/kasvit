package com.ohj4.kasvit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.concurrent.RecursiveAction;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    public static ArrayList<Plant> plantsList;
    private RecyclerView recyclerView;
    PlantsRecyclerAdapter adapter;

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

    @Override
    protected void onStart() {

        super.onStart();
        adapter.notifyDataSetChanged();
    }

    public void addPlant(View view) {
        Intent myIntent = new Intent(MainActivity.this, PlantActivity.class);
        myIntent.putExtra("PLANT", new Plant());
        MainActivity.this.startActivity(myIntent);
    }

    private void SetPlantInfo() {

        plantsList.add(new Plant("Kukka"));
        plantsList.add(new Plant("Toinen Kukka"));

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
        this.recyclerView = findViewById(R.id.recycler_view);
        this.adapter = new PlantsRecyclerAdapter(this, plantsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void openPreferences(View view) {
        Intent myIntent = new Intent(MainActivity.this, PreferencesActivity.class);
        MainActivity.this.startActivity(myIntent);
    }
}