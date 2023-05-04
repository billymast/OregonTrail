package com.example.oregontrail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

public class RiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_river);

        // River Event Elements
        final TextView riverDepthText = findViewById(R.id.riverDepthText);
        final TextView riverWidthText = findViewById(R.id.riverWidthText);
        final Button riverFordButton = findViewById(R.id.riverFordButton);
        final Button riverFloatButton = findViewById(R.id.riverFloatButton);
        final Button riverFerryButton = findViewById(R.id.riverFerryButton);
        final Button riverWaitButton = findViewById(R.id.riverWaitButton);

        River currentRiver = getIntent().getExtras().getParcelable("currentRiver");

        configurebackButton();

        riverDepthText.setText("River Depth: " + currentRiver.getDepth());
        riverWidthText.setText("River Width: " + currentRiver.getWidth());

        // Buttons For River Event

        riverFordButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


            }
        });

        riverFloatButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


            }
        });

        riverFerryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


            }
        });

        riverWaitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                /**
                // Updates and displays changes to weather
                weather.dailyWeather(time);
                weatherConditionText.setText(weather.weatherTypeString());
                weatherTempText.setText(weather.getTempType());

                // Updates and displays changes to party's health
                health.PartyUpdate(weather, inventory, map, true);
                healthText.setText("Health: " + health.getParty());

                // Updates and displays food count
                inventory.removeInventory("Food", 20);
                foodText.setText("Food: " + Integer.toString(inventory.getInventoryValue("Food")));

                // Update and Display the new date
                dateTextChange.setText(time.outputDate());
                time.updateDay(1);
                 */
            }
        });
    }

    private void configurebackButton(){
        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}