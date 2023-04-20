package com.example.oregontrail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // All Objects used in game
    Health health = new Health();
    Inventory inventory = new Inventory();
    Map map = new Map();
    Time time = new Time();
    Weather weather = new Weather();
    RandomEvent randomEvent = new RandomEvent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // All objects of text boxes, images, or buttons
        final TextView gamePlayText = findViewById(R.id.gamePlayText);
        final TextView dateTextChange = findViewById(R.id.dateTextChange);
        final TextView weatherTempText = findViewById(R.id.weatherTempText);
        final TextView weatherConditionText = findViewById(R.id.weatherConditionText);
        final TextView distanceLandmarkText = findViewById(R.id.distanceLandmarkText);
        final TextView distanceTraveledText = findViewById(R.id.distanceTraveledText);
        final TextView paceText = findViewById(R.id.paceText);
        final TextView healthText = findViewById(R.id.healthText);
        final TextView foodText = findViewById(R.id.foodText);
        final Button nextDayButton = findViewById(R.id.nextDay);
        final TextView locationText = findViewById(R.id.locationText);
        final Button paceButton = findViewById(R.id.paceButton);
        final Button normalPaceButton = findViewById(R.id.normalPaceButton);
        final Button strenuousPaceButton = findViewById(R.id.strenuousPaceButton);
        final Button gruelingPaceButton = findViewById(R.id.gruelingPaceButton);
        final Button exitOptionsButton = findViewById(R.id.exitOptionsButton);
        final ImageView optionsBackground2 = findViewById(R.id.optionsBackground2);


        // General Store Screen
        final TextView storeFoodText = findViewById(R.id.storeFoodText);
        final TextView storeFoodAmount = findViewById(R.id.storeFoodAmount);
        final Button storeDecrementFood = findViewById(R.id.storeDecrementFood);
        final Button storeIncrementFood = findViewById(R.id.storeIncrementFood);
        final TextView storeFoodCost = findViewById(R.id.storeFoodCost);
        final TextView storeYourAmount = findViewById(R.id.storeYourAmount);


        // When next day button is clicked
        nextDayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String dailyOutput = time.outputDate() + "\n";

                // Updates and displays changes to weather
                weather.dailyWeather(time);
                weatherConditionText.setText(weather.weatherTypeString());
                weatherTempText.setText(weather.getTempType());

                // Updates and displays changes to party's health
                health.PartyUpdate(weather, inventory, map);
                healthText.setText("Health: " + health.getParty());

                // Updates and displays location
                if(map.updateLocation()){
                    locationText.setText(map.getCurrentLandmark());
                }
                distanceTraveledText.setText("Traveled: " + map.getLocation());
                distanceLandmarkText.setText("To Landmark: " + map.distanceToNextLandmark());

                // Updates and displays food count
                inventory.removeInventory("Food", 20);
                foodText.setText("Food: " + Integer.toString(inventory.getInventoryValue("Food")));

                // Checks whether a fort is reached
                if (map.isFort()){
                    dailyOutput = dailyOutput + "You have reached " + map.getCurrentLandmark() + ".\n";
                }
                // Checks whether a river is reached
                else if (map.isRiver()) {
                    dailyOutput = dailyOutput + "You have reached " + map.getCurrentLandmark() + ".\n";
                }
                // Otherwise check for any random events that may occur
                else {
                    dailyOutput = dailyOutput + "Random Event: " + randomEvent.Event(inventory, weather, time) + ".\n";
                }

                // Displays Text explaining what happened during the day
                gamePlayText.setText(dailyOutput);

                // Update and Display the new date
                time.updateDay(1);
                dateTextChange.setText(time.outputDate());
            }

        });

        // When the Pace button is clicked
        paceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nextDayButton.setVisibility(View.GONE);
                optionsBackground2.setVisibility(View.VISIBLE);
                normalPaceButton.setVisibility(View.VISIBLE);
                strenuousPaceButton.setVisibility(View.VISIBLE);
                gruelingPaceButton.setVisibility(View.VISIBLE);
                exitOptionsButton.setVisibility(View.VISIBLE);
            }
        });

        // When Exit button is clicked in the options menu
        exitOptionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nextDayButton.setVisibility(View.VISIBLE);
                optionsBackground2.setVisibility(View.GONE);
                normalPaceButton.setVisibility(View.GONE);
                strenuousPaceButton.setVisibility(View.GONE);
                gruelingPaceButton.setVisibility(View.GONE);
                exitOptionsButton.setVisibility(View.GONE);
            }
        });

        // Buttons for General Store
        storeDecrementFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        storeIncrementFood.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //storeFoodAmount.setText(String.valueOf(storeFoodAmount.getText()) + 1);
            }
        });

        // Buttons for Pace Menu
        normalPaceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                map.setPaceType("Normal");
                paceText.setText("Pace: Normal");
            }
        });

        strenuousPaceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                map.setPaceType("Strenuous");
                paceText.setText("Pace: Strenuous");
            }
        });

        gruelingPaceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                map.setPaceType("Grueling");
                paceText.setText("Pace: Grueling");
            }
        });

    }



}