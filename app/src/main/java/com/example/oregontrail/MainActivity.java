package com.example.oregontrail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

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
        final TextView dateText = findViewById(R.id.dateText);
        final TextView weatherText = findViewById(R.id.weatherText);
        final TextView healthText = findViewById(R.id.healthText);
        final TextView foodText = findViewById(R.id.foodText);
        final TextView distanceText = findViewById(R.id.distanceText);
        final Button nextDayButton = findViewById(R.id.nextDay);

        // When next day button is clicked
        nextDayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Updates and displays changes to weather
                weather.dailyWeather();
                weatherText.setText("Weather: " + weather.getTempType());

                // Updates and displays changes to party's health
                health.PartyUpdate(weather, inventory, map);
                healthText.setText("Health: " + health.getParty());

                // Updates and displays location
                map.updateLocation();
                distanceText.setText("Distance: " + map.getLocation());

                // Updates and displays food count
                inventory.removeInventory("Food", 20);
                foodText.setText("Food: " + Integer.toString(inventory.getInventoryValue("Food")));

                // Checks whether a fort is reached
                if (map.isFort()){
                    gamePlayText.setText("You have reached Fort Kearney");
                }
                // Checks whether a river is reached
                else if (map.isRiver()) {
                    gamePlayText.setText("You have reached a river");
                }
                // Otherwise check for any random events that may occur
                else {
                    gamePlayText.setText(randomEvent.Event());
                }

                // Update and Display the new date
                time.updateDay();
                dateText.setText("Date: " + time.outputDate());
            }
        });

    }



}