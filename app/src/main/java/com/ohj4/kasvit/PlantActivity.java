package com.ohj4.kasvit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class PlantActivity extends AppCompatActivity {

    private static final String TAG = "PlantActivity";

    private boolean editModeEnabled = true;
    private boolean isNewPlantBeingCreated = true;
    private int plantIndex = -1;
    private Plant plant;
    private ArrayList<Plant> plants;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);
        //hide action bar
        getSupportActionBar().hide();
        Log.d(TAG, "onCreate: started.");
        getIncomingIntent();
        if (plantIndex > -1) {
            setEditable(false);
        }
        initRecyclerView();
    }

    private void getIncomingIntent() {
        Log.d(TAG, "getIncomingIntent: Checking for incoming intents.");
        try {
            Log.d(TAG, "getIncomingIntent: found intent extras.");
            this.plant = (Plant) getIntent().getSerializableExtra("PLANT");
            this.plantIndex = getIntent().getIntExtra("INDEX", -1);
            updateFieldsWithPlantInfo(this.plant.getName(), this.plant.getDescription());
        } catch (Exception e) {

        }
    }

    private void updateFieldsWithPlantInfo(String plantName, String plantDesc) {
        Log.d(TAG, "setPlantName: setting plant name to widget.");

        EditText name = findViewById(R.id.plantNameTextView);
        EditText desc = findViewById(R.id.plantDescriptionTextView);

        name.setText(plantName);
        desc.setText(plantDesc);

        plant.setName(plantName);
        plant.setDescription(plantDesc);

    }

    private void setEditable(boolean bool) {
        Log.d(TAG, "setEditable: setting editable to: " + bool);

        EditText name = findViewById(R.id.plantNameTextView);
        EditText desc = findViewById(R.id.plantDescriptionTextView);
        Button edit = findViewById(R.id.editButton);

        name.setFocusable(bool);
        name.setFocusableInTouchMode(bool);
        name.setClickable(bool);
        desc.setFocusable(bool);
        desc.setFocusableInTouchMode(bool);
        desc.setClickable(bool);
        editModeEnabled = bool;


        //PRESS EIDT
        if (editModeEnabled) {
            edit.setText("Tallenna");
            findViewById(R.id.alarm_switch).setVisibility(View.GONE);
            findViewById(R.id.alarms_recycler_view).setVisibility(View.VISIBLE);
        } else {
            //PRESS READY
            findViewById(R.id.alarm_switch).setVisibility(View.VISIBLE);
            findViewById(R.id.alarms_recycler_view).setVisibility(View.GONE);
            edit.setText("Muokkaa");

            modifyPlantInfo();

            if (plantIndex < 0) {
                MainActivity.plantsList.add(this.plant);
                this.plantIndex =  MainActivity.plantsList.size()-1;
            } else {
                MainActivity.plantsList.set(
                        this.plantIndex,
                        this.plant
                );
            }
        }
    }

    private void modifyPlantInfo() {
        EditText name = findViewById(R.id.plantNameTextView);
        EditText desc = findViewById(R.id.plantDescriptionTextView);

        this.plant.setName(name.getText().toString());
        this.plant.setDescription(desc.getText().toString());
    }


    public void toggleEditable(View view) {
        setEditable(!editModeEnabled);
    }


    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.alarms_recycler_view);
        AlarmsRecyclerAdapter adapter = new AlarmsRecyclerAdapter(this, plant.getAlarms());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public void goBackToPreviousActivity(View view) {
        onBackPressed();
    }


}