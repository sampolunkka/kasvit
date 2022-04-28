package com.ohj4.kasvit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PlantActivity extends AppCompatActivity {

    private static final String TAG ="PlantActivity";

    private boolean editModeEnabled = true;
    private Plant plant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);
        //hide action bar
        getSupportActionBar().hide();
        Log.d(TAG, "onCreate: started.");
        getIncomingIntent();
        setEditable(false);
    }

    private  void getIncomingIntent() {
        Log.d(TAG, "getIncomingIntent: Checking for incoming intents.");
        try{
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String plantName = getIntent().getStringExtra("plant_name");
            String plantDesc = getIntent().getStringExtra("plant_desc");

            setPlantInfo(plantName, plantDesc);

        } catch (Exception e) {

        }
    }

    private void setPlantInfo(String plantName, String plantDesc) {
        Log.d(TAG, "setPlantName: setting plant name to widget.");

        EditText name = findViewById(R.id.plantNameTextView);
        EditText desc = findViewById(R.id.plantDescriptionTextView);

        name.setText(plantName);
        desc.setText(plantDesc);
    }

    private void setEditable(boolean bool) {
        Log.d(TAG, "setEditable: setting editable to: " + bool);

        EditText name = findViewById(R.id.plantNameTextView);
        EditText desc = findViewById(R.id.plantDescriptionTextView);
        Button edit= findViewById(R.id.editButton);

        name.setFocusable(bool);
        name.setFocusableInTouchMode(bool);
        name.setClickable(bool);
        desc.setFocusable(bool);
        desc.setFocusableInTouchMode(bool);
        desc.setClickable(bool);
        editModeEnabled = bool;

        if (editModeEnabled) {
           edit.setText("Valmis");
        } else {
            edit.setText("Muokkaa");
        }

    }

    public void toggleEditable (View view) {
        setEditable(!editModeEnabled);
    }


}