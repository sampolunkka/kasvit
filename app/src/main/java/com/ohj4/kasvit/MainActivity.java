package com.ohj4.kasvit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Plant> plantsList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hide action bar
        getSupportActionBar().hide();


        recyclerView = findViewById(R.id.plantsRecyclerView);
        plantsList = new ArrayList<Plant>();

        SetPlantInfo();
        setAdapter();
    }

    public void addPlant(View view) {
        plantsList.add(new Plant());
    }

    private void SetPlantInfo() {

        plantsList.add(new Plant("lol"));
        plantsList.add(new Plant("Janne"));

    }

    private void setAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(plantsList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}